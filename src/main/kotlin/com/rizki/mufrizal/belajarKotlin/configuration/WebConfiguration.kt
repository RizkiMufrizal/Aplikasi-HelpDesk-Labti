package com.rizki.mufrizal.belajarKotlin.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 01 March 2016, 15:27
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.configuration
 */

@Configuration
open class WebConfiguration : WebMvcConfigurerAdapter() {

    override fun addViewControllers(viewControllerRegistry: ViewControllerRegistry) {
        viewControllerRegistry.addViewController("/").setViewName("index")
    }

}