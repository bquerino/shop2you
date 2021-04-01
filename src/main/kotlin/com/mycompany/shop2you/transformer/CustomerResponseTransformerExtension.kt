package com.mycompany.shop2you.transformer

import com.mycompany.shop2you.domain.Customer
import com.mycompany.shop2you.dto.CustomerResponse

fun Customer?.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(
        id = this?.id ?: 1L,
        fullName = "${this?.firstName} ${this?.lastName}"
    )
}