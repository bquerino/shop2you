package com.mycompany.shop2you.dto

data class AddCustomerRequest(
    val firstName: String,
    val lastName: String? = null
)