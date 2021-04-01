package com.mycompany.shop2you.dto

import java.time.LocalDateTime

data class ErrorResponse(
    val messageTitle: String = "Bad request",
    val message: String,
    val dateTime: LocalDateTime = LocalDateTime.now()
)