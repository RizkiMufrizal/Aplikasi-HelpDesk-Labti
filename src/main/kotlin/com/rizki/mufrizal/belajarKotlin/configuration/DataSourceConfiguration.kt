package com.rizki.mufrizal.belajarKotlin.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import javax.sql.DataSource


/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 01 March 2016, 15:09
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.configuration
 */

@Configuration
@PropertySource("classpath:application.yml")
open class DataSourceConfiguration {

    @Autowired
    private val environment: Environment? = null

    @Bean(destroyMethod = "close")
    open fun dataSource(): DataSource {
        val dataSourceConfig = HikariConfig()
        dataSourceConfig.driverClassName = environment!!.getRequiredProperty("spring.datasource.driver-class-name")
        dataSourceConfig.jdbcUrl = environment.getRequiredProperty("spring.datasource.url")
        dataSourceConfig.username = environment.getRequiredProperty("spring.datasource.username")
        dataSourceConfig.password = environment.getRequiredProperty("spring.datasource.password")
        dataSourceConfig.maximumPoolSize = Integer.parseInt(environment.getRequiredProperty("spring.datasource.maximumPoolSize"))
        dataSourceConfig.minimumIdle = Integer.parseInt(environment.getRequiredProperty("spring.datasource.minimumIdle"))
        dataSourceConfig.maxLifetime = Integer.parseInt(environment.getRequiredProperty("spring.datasource.maxLifetime")).toLong()
        dataSourceConfig.connectionTimeout = java.lang.Long.parseLong(environment.getRequiredProperty("spring.datasource.connectionTimeout"))
        dataSourceConfig.idleTimeout = java.lang.Long.parseLong(environment.getRequiredProperty("spring.datasource.idleTimeout"))
        dataSourceConfig.addDataSourceProperty("poolName", environment.getRequiredProperty("spring.datasource.poolName"))
        dataSourceConfig.addDataSourceProperty("cachePrepStmts", "true")
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", "250")
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
        return HikariDataSource(dataSourceConfig)
    }

}