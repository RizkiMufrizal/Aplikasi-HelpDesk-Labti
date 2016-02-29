package com.rizki.mufrizal.aplikasi.helpdesk.labti

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ServerApplication::class.java, *args)
}
