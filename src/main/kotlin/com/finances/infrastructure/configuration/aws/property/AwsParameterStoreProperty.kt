package com.finances.infrastructure.configuration.aws.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.cloud.aws.parameterstore")
data class AwsParameterStoreProperty (
    val region : String,
    val endpoint : String?
)