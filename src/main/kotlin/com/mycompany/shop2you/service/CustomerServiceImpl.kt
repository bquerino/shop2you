package com.mycompany.shop2you.service

import com.mycompany.shop2you.dao.CustomerDao
import com.mycompany.shop2you.domain.Customer
import com.mycompany.shop2you.dto.AddCustomerRequest
import com.mycompany.shop2you.dto.CustomerResponse
import com.mycompany.shop2you.dto.UpdateCustomerRequest
import com.mycompany.shop2you.transformer.AddCustomerRequestTransformer
import com.mycompany.shop2you.transformer.toCustomerResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(private val customerDao: CustomerDao, private val addCustomerRequestTransformer: AddCustomerRequestTransformer): CustomerService {

    override fun findById(id: Long): CustomerResponse? = this.findCustomerById(id).toCustomerResponse()

    override fun findAll(pageable: Pageable): Page<CustomerResponse> =
        this.customerDao.findAll(pageable).map(Customer::toCustomerResponse)

    override fun save(addCustomerRequest: AddCustomerRequest): CustomerResponse {
        return this.saveOrUpdate(addCustomerRequestTransformer.transform(addCustomerRequest))
    }

    override fun update(updateCustomerRequest: UpdateCustomerRequest): CustomerResponse {
        val customer = this.findCustomerById(updateCustomerRequest.id)
            ?: throw IllegalStateException("{updateCustomerRequest.id} not found")

        return this.saveOrUpdate(customer.apply {
            this.firstName = updateCustomerRequest.firstName
            this.lastName = updateCustomerRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.customerDao.deleteById(id)
    }

    private fun findCustomerById(id: Long): Customer? = this.customerDao.findByIdOrNull(id)

    private fun saveOrUpdate(customer: Customer): CustomerResponse =
        this.customerDao.save(customer).toCustomerResponse()
}