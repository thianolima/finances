#!/bin/bash
awslocal secretsmanager create-secret --name /secret/db-credential --secret-string '{"dbuser": "admin", "dbpassword": "", "dburl": "jdbc:h2:mem:finances-db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"}'
awslocal secretsmanager list-secrets

awslocal ssm --overwrite put-parameter --name "/config/toogle1" --value "true"   --type String
awslocal ssm --overwrite put-parameter --name "/config/toogle2" --value "false"  --type String
awslocal ssm --overwrite put-parameter --name "/config/toogle3" --value "false"  --type String
awslocal ssm describe-parameters
