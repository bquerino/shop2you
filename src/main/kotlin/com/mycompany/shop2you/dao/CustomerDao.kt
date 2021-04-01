package com.mycompany.shop2you.dao

import com.mycompany.shop2you.domain.Customer
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerDao : JpaRepository<Customer, Long> {

}