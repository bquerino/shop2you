package com.mycompany.shop2you.transformer

import com.mycompany.shop2you.domain.Customer
import com.mycompany.shop2you.dto.AddCustomerRequest
import org.springframework.stereotype.Component

@Component
class AddCustomerRequestTransformer: Transformer<AddCustomerRequest, Customer> {
    override fun transform(source: AddCustomerRequest): Customer {
        return Customer(
            firstName = source.firstName,
            lastName = source.lastName
        )
    }
}