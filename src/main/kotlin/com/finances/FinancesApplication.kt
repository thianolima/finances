package com.finances

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FinancesApplication{

    @Bean
    fun applicationRunner(
        @Value("\${dbuser}") username : String?,
        @Value("\${dbpassword}") password : String?,
        @Value("\${dburl}") url : String?
    ): ApplicationRunner? {
        return ApplicationRunner {
            println("Username: $username")
            println("Password: $password")
            println("URL: $url")
        }
    }

}

fun main(args: Array<String>) {
    runApplication<FinancesApplication>(*args)
}