package com.rizki.mufrizal.aplikasi.helpdesk.labti.repository

import com.rizki.mufrizal.aplikasi.helpdesk.labti.domain.Problem
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.security.access.prepost.PreAuthorize

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since 03 March 2016, 21:39
 * @Project Server
 * @Package com.rizki.mufrizal.aplikasi.helpdesk.labti.repository
 */

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "problem", path = "problem")
interface ProblemRepository : PagingAndSortingRepository<Problem, String> {
}