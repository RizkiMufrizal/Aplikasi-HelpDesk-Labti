package com.rizki.mufrizal.aplikasi.helpdesk.labti.service

import com.rizki.mufrizal.aplikasi.helpdesk.labti.domain.UserRole
import com.rizki.mufrizal.aplikasi.helpdesk.labti.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 03 March 2016, 19:57
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.service
 */

@Service
class UserService : UserDetailsService {

    @Autowired
    private val userRepository: UserRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val user = userRepository!!.findOne(username)

        if (user != null) {
            val authorities = buildUserAuthority(user.userRoles)
            return buildUserForAuthentication(user, authorities)
        } else {
            return null
        }

    }

    private fun buildUserForAuthentication(user: com.rizki.mufrizal.aplikasi.helpdesk.labti.domain.User, grantedAuthorities: List<GrantedAuthority>): User {
        return User(user.email, user.password, user.enable, true, true, true, grantedAuthorities)
    }

    private fun buildUserAuthority(userRoles: Set<UserRole>): List<GrantedAuthority> {
        val grantedAuthorities = HashSet<GrantedAuthority>()

        for (userRole in userRoles) {
            grantedAuthorities.add(SimpleGrantedAuthority(userRole.role))
        }

        return ArrayList(grantedAuthorities)
    }

}