package com.mycompany.shop2you.domain

import java.time.LocalDateTime
import javax.persistence.*


@Entity
data class Customer(
    @Id
    @SequenceGenerator(name = CUSTOMER_SEQUENCE, sequenceName = CUSTOMER_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CUSTOMER_SEQUENCE)
    val id: Long = 1,
    var firstName: String? = "",
    var lastName: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val lastUpdate: LocalDateTime = LocalDateTime.now()) {

    companion object {
        const val CUSTOMER_SEQUENCE: String = "CUSTOMER_SEQUENCE"
    }
}