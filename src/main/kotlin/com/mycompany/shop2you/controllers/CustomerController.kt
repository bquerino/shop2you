package com.mycompany.shop2you.controllers

import com.mycompany.shop2you.controllers.CustomerController.Companion.BASE_CUSTOMER_URL
import com.mycompany.shop2you.dto.AddCustomerRequest
import com.mycompany.shop2you.dto.CustomerResponse
import com.mycompany.shop2you.dto.UpdateCustomerRequest
import com.mycompany.shop2you.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_CUSTOMER_URL])
class CustomerController(private val customerService: CustomerService): CustomerResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<CustomerResponse?> {
        val customerResponse: CustomerResponse? = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse)
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<CustomerResponse>> {
        return ResponseEntity.ok(this.customerService.findAll(pageable))
    }

    @PostMapping
    override fun save(@RequestBody addCustomerRequest: AddCustomerRequest): ResponseEntity<CustomerResponse> {
        val customerResponse = this.customerService.save(addCustomerRequest)
        return ResponseEntity
            .created(URI.create(BASE_CUSTOMER_URL.plus("/${customerResponse.id}")))
            .body(customerResponse)
    }

    @PutMapping
    override fun update(@RequestBody updateCustomerRequest: UpdateCustomerRequest): ResponseEntity<CustomerResponse> {
        return ResponseEntity.ok(this.customerService.update(updateCustomerRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.customerService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_CUSTOMER_URL: String = "/customers"
    }
}
