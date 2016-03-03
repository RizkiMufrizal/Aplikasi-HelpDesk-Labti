package com.rizki.mufrizal.aplikasi.helpdesk.labti.domain

import java.io.Serializable
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 01 March 2016, 15:37
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.domain
 */

@Entity
@Table(name = "tb_user")
class User : Serializable {

    @Id
    @Column(name = "email", length = 30)
    var email: String? = null

    @Column(name = "password", length = 150)
    var password: String? = null

    @Column(name = "enable")
    var enable: Boolean = java.lang.Boolean.TRUE

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    var userRoles: Set<UserRole> = HashSet()

}