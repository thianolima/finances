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
        @Value("\${dburl}") url : String?,
        @Value("\${toogle1}") toogle1 : Boolean?,
        @Value("\${toogle2}") toogle2 : Boolean?,
        @Value("\${toogle3}") toogle3 : Boolean?
    ): ApplicationRunner? {
        return ApplicationRunner {
            println("Username: $username")
            println("Password: $password")
            println("URL: $url")
            println("Toogle 1: $toogle1")
            println("Toogle 2: $toogle2")
            println("Toogle 3: $toogle3")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<FinancesApplication>(*args)
}