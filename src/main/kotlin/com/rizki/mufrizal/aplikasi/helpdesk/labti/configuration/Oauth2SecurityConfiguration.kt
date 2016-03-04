package com.rizki.mufrizal.aplikasi.helpdesk.labti.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.web.access.channel.ChannelProcessingFilter

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 03 March 2016, 21:04
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.configuration
 */

@Configuration
open class Oauth2SecurityConfiguration {

    @Configuration
    @EnableResourceServer
    protected open class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

        override fun configure(resourceServerSecurityConfigurer: ResourceServerSecurityConfigurer) {
            resourceServerSecurityConfigurer
                    .resourceId("belajar");
        }

        override fun configure(httpSecurity: HttpSecurity) {
            httpSecurity
                    .authorizeRequests()
                    .antMatchers("/api").fullyAuthenticated()
                    .antMatchers("/").permitAll()
                    .and()
                    .addFilterBefore(CORSFilter(), ChannelProcessingFilter::class.java)
        }

    }

    @Configuration
    @EnableAuthorizationServer
    protected open class AuthorizationServerConfiguration : AuthorizationServerConfigurerAdapter() {

        @Autowired
        @Qualifier("authenticationManagerBean")
        private val authenticationManager: AuthenticationManager? = null

        @Bean
        open fun jwtAccessTokenConverter(): JwtAccessTokenConverter {
            return JwtAccessTokenConverter()
        }

        override fun configure(authorizationServerEndpointsConfigurer: AuthorizationServerEndpointsConfigurer) {
            authorizationServerEndpointsConfigurer
                    .accessTokenConverter(jwtAccessTokenConverter())
                    .authenticationManager(authenticationManager)
        }

        override fun configure(clientDetailsServiceConfigurer: ClientDetailsServiceConfigurer) {
            clientDetailsServiceConfigurer
                    .inMemory()
                    .withClient("clientapp")
                    .authorizedGrantTypes("password", "refresh_token")
                    .authorities("USER")
                    .scopes("read", "write")
                    .resourceIds("belajar")
                    .secret("123456")
        }

    }

}