package com.rizki.mufrizal.aplikasi.helpdesk.labti.domain

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 03 March 2016, 21:32
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.domain
 */

@Entity
@Table(name = "tb_problem")
class Problem : Serializable {

    @Id
    @Column(name = "id_problem", length = 150)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    var idProblem: String? = null

    @Column(name = "judul", length = 50)
    var judul: String? = null

    @Lob
    @Column(name = "deskripsi")
    var deskripsi: String? = null

    @Column(name = "status", length = 10)
    @Enumerated(EnumType.STRING)
    var status: Status = Status.belum

    @Column(name = "tanggalProblem")
    @Temporal(TemporalType.TIMESTAMP)
    var tanggalProble: Date = Date()

}