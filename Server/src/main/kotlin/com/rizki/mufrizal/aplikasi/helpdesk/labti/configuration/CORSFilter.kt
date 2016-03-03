package com.rizki.mufrizal.aplikasi.helpdesk.labti.configuration

import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 01 March 2016, 14:23
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.configuration
 */

@Component
class CORSFilter : Filter {

    override fun init(filterChain: FilterConfig) {

    }

    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val httpServletResponse: HttpServletResponse = servletResponse as HttpServletResponse
        val httpServletRequest: HttpServletRequest = servletRequest as HttpServletRequest

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*")
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT")
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600")
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "accept, authorization, x-requested-with, content-type")

        if (httpServletRequest.method.equals("OPTIONS"))
            try {
                httpServletResponse.status = 200
                httpServletResponse.writer.print("OK")
                httpServletResponse.writer.flush()
            } catch(e: IOException) {

            }
        else
            filterChain.doFilter(servletRequest, servletResponse)
    }

    override fun destroy() {

    }
}