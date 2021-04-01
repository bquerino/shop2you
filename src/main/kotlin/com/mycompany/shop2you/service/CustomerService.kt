package com.mycompany.shop2you.service

import com.mycompany.shop2you.domain.Customer
import com.mycompany.shop2you.dto.AddCustomerRequest
import com.mycompany.shop2you.dto.CustomerResponse
import com.mycompany.shop2you.dto.UpdateCustomerRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CustomerService {
    fun findById(id:Long): CustomerResponse?
    fun findAll(pageable: Pageable): Page<CustomerResponse>
    fun save(addCustomerRequest: AddCustomerRequest): CustomerResponse
    fun update(updateCustomerRequest: UpdateCustomerRequest): CustomerResponse
    fun deleteById(id: Long)
}