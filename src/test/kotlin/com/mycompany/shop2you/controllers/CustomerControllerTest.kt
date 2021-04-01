package com.mycompany.shop2you.controllers

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest() {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun testTouchCustomerEndpoint(){
        val result = testRestTemplate.getForEntity("/customers", String::class.java)
        assertEquals(result.statusCode, HttpStatus.OK)
    }

}