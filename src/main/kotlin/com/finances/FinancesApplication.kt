package com.finances

import com.finances.infrastructure.configuration.aws.property.AwsCredentialsProperty
import com.finances.infrastructure.configuration.aws.property.AwsParameterStoreProperty
import com.finances.infrastructure.configuration.aws.property.AwsSecretsMangerProperty
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@ConfigurationPropertiesScan
class FinancesApplication{

    @Bean
    fun applicationRunner(
        @Value("\${dbuser}") username : String?,
        @Value("\${dbpassword}") password : String?,
        @Value("\${dburl}") url : String?,
        @Value("\${toogle1}") toogle1 : Boolean?,
        @Value("\${toogle2}") toogle2 : Boolean?,
        @Value("\${toogle3}") toogle3 : Boolean?,
        awsCredentialProperty: AwsCredentialsProperty,
        awsSecretsMangerProperty: AwsSecretsMangerProperty,
        awsParameterStoreProperty: AwsParameterStoreProperty
    ): ApplicationRunner? {
        return ApplicationRunner {
            println("Username: $username")
            println("Password: $password")
            println("URL: $url")

            println("Toogle 1: $toogle1")
            println("Toogle 2: $toogle2")
            println("Toogle 3: $toogle3")

            println("AwsCredentials: $awsCredentialProperty")
            println("AwsSecretsManager: $awsSecretsMangerProperty")
            println("AwsParameterStore: $awsParameterStoreProperty")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<FinancesApplication>(*args)
}