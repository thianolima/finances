//package com.finances.infrastructure.configuration.aws
//
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//class S3Configuration {
//
//    @Value("\${aws.region}")
//    lateinit var awsRegion : String
//    @Value("\${aws.credentials.accessKey}")
//    lateinit var accessKey : String
//    @Value("\${aws.credentials.secretKey}")
//    lateinit var secretKey : String

//    @Bean
//    fun s3Client() : S3Client =
//         S3Client
//            .builder()
//            .region(
//                Region.regions().find {
//                        region -> region.toString() == awsRegion
//                } )
//            .credentialsProvider(
//                StaticCredentialsProvider.create(
//                    AwsBasicCredentials.create(accessKey, secretKey)
//                )
//            )
//            .build()
//}