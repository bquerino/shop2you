package com.mycompany.shop2you.controllers

import com.mycompany.shop2you.dto.AddCustomerRequest
import com.mycompany.shop2you.service.CustomerService
import com.ninjasquad.springmockk.MockkBean
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc


@WebMvcTest
class HttpCustomerControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var customerService: CustomerService

    @Test
    fun `List customers`(){
        // TODO: 28/03/2021
    }

    @Test
    fun `Find some customer`(){
        // TODO: 28/03/2021
    }

    @Test
    fun `Save customer`(){
        // TODO: 28/03/2021
    }

    @Test
    fun `Update customer`(){
        // TODO: 28/03/2021
    }

    @Test
    fun `Delete customer`(){
        // TODO: 28/03/2021
    }


}