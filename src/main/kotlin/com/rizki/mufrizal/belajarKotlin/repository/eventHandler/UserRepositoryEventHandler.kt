package com.rizki.mufrizal.belajarKotlin.repository.eventHandler

import com.rizki.mufrizal.belajarKotlin.domain.User
import com.rizki.mufrizal.belajarKotlin.domain.UserRole
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import java.util.HashSet

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 03 March 2016, 18:35
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.repository.eventHandler
 */

@Component
@RepositoryEventHandler(User::class)
class UserRepositoryEventHandler {

    @HandleBeforeCreate
    fun handleUserBeforeCreate(user: User) {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        user.password = bCryptPasswordEncoder.encode(user.password)

        val userRole = UserRole()
        userRole.user = user

        val userRoles: Set<UserRole> = HashSet()
        userRoles.plus(userRole)
        user.userRoles = userRoles
    }

}