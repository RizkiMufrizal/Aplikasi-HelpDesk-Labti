package com.rizki.mufrizal.aplikasi.helpdesk.labti.repository

import com.rizki.mufrizal.aplikasi.helpdesk.labti.domain.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.security.access.prepost.PreAuthorize

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 03 March 2016, 18:27
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.repository
 */

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
interface UserRepository : PagingAndSortingRepository<User, String> {

    @PreAuthorize("permitAll")
    @Query("select u from User u left join fetch u.userRoles ur where u.email = :email")
    fun authenticateUser(@Param("email") email: String): User

    @PreAuthorize("permitAll")
    override fun <S : User?> save(p0: S): S

}