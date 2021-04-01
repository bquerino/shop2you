package com.mycompany.shop2you.dto

data class UpdateCustomerRequest(
    val id: Long,
    val firstName: String,
    val lastName: String? = null
)