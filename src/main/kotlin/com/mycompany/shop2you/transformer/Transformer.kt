package com.mycompany.shop2you.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}