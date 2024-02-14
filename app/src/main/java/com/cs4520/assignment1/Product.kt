package com.cs4520.assignment1
sealed class Product(
    open val name: String,
    open val expirationDate: String,
    open val price: Int) {
}

data class Equipment(
    override val name: String,
    override val expirationDate: String,
    override val price: Int
) : Product(name, expirationDate, price) {
}

data class Food(
    override val name: String,
    override val expirationDate: String,
    override val price: Int
) : Product(name, expirationDate, price) {
}