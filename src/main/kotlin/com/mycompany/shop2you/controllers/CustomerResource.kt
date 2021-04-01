package com.mycompany.shop2you.controllers

import com.mycompany.shop2you.dto.AddCustomerRequest
import com.mycompany.shop2you.dto.CustomerResponse
import com.mycompany.shop2you.dto.UpdateCustomerRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface CustomerResource {
    fun findById(id: Long): ResponseEntity<CustomerResponse?>
    fun findAll(pageable: Pageable): ResponseEntity<Page<CustomerResponse>>
    fun save(addCustomerRequest: AddCustomerRequest): ResponseEntity<CustomerResponse>
    fun update(updateCustomerRequest: UpdateCustomerRequest): ResponseEntity<CustomerResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
}