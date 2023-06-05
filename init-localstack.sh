#!/bin/bash
echo "########### Setting Secrets ##########"
awslocal secretsmanager create-secret --name /secret/db-credential --secret-string '{"dbuser": "admin", "dbpassword": "", "dburl": "jdbc:h2:mem:finances-db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"}'
awslocal secretsmanager list-secrets

echo "########### Setting Parameter Store ###########"
awslocal ssm --overwrite put-parameter --name "/config/toogle1" --value "true"   --type String
awslocal ssm --overwrite put-parameter --name "/config/toogle2" --value "false"  --type String
awslocal ssm --overwrite put-parameter --name "/config/toogle3" --value "false"  --type String
awslocal ssm describe-parameters

echo "########### Setting Enivorments ###########"
export UPLOAD_FILE_EVENT_SQS=upload-file-event-sqs
export BUCKET_NAME=invoices
export AWS_REGION=us-east-1

echo "########### Creating upload file event SQS ###########"
awslocal sqs create-queue --queue-name $UPLOAD_FILE_EVENT_SQS

echo "########### ARN for upload file event SQS ###########"
UPLOAD_FILE_EVENT_SQS_ARN=$(awslocal sqs get-queue-attributes\
                  --attribute-name QueueArn --queue-url=http://localhost:4566/000000000000/"$UPLOAD_FILE_EVENT_SQS"\
                  |  sed 's/"QueueArn"/\n"QueueArn"/g' | grep '"QueueArn"' | awk -F '"QueueArn":' '{print $2}' | tr -d '"' | xargs)

echo "########### Listing queues ###########"
awslocal sqs list-queues

echo "########### Create S3 bucket ###########"
awslocal s3api create-bucket --bucket $BUCKET_NAME --region $AWS_REGION

echo "########### List S3 bucket ###########"
awslocal s3api list-buckets

echo "########### Set S3 bucket notification configurations ###########"
awslocal s3api put-bucket-notification-configuration\
    --bucket $BUCKET_NAME\
    --notification-configuration  '{
                                      "QueueConfigurations": [
                                         {
                                           "QueueArn": "'"$UPLOAD_FILE_EVENT_SQS_ARN"'",
                                           "Events": ["s3:ObjectCreated:*"]
                                         }
                                       ]
                                     }'

echo "########### Get S3 bucket notification configurations ###########"
awslocal s3api get-bucket-notification-configuration --bucket $BUCKET_NAME