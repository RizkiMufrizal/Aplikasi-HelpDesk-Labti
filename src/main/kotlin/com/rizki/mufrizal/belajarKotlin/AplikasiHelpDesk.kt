package com.rizki.mufrizal.belajarKotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 01 March 2016, 14:21
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti
 */

@SpringBootApplication
@EnableRedisHttpSession
@EnableHypermediaSupport(type = arrayOf(EnableHypermediaSupport.HypermediaType.HAL))
open class AplikasiHelpDesk

fun main(args: Array<String>) {
    SpringApplication.run(AplikasiHelpDesk::class.java, *args)
}