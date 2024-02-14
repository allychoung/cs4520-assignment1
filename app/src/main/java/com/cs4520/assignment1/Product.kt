package com.cs4520.assignment1
sealed class Product(
    open val name: String,
    open val expirationDate: String?,
    open val price: Int) {
    abstract fun getBackgroundImg(): Int
    abstract fun getBackgroundColor(): Int
}

data class Equipment(
    override val name: String,
    override val expirationDate: String?,
    override val price: Int
) : Product(name, expirationDate, price) {
    override fun getBackgroundImg(): Int {
        return R.drawable.equipment
    }

    override fun getBackgroundColor(): Int {
        return R.color.light_red
    }
}

data class Food(
    override val name: String,
    override val expirationDate: String?,
    override val price: Int
) : Product(name, expirationDate, price) {
    override fun getBackgroundImg(): Int {
        return R.drawable.food
    }

    override fun getBackgroundColor(): Int {
        return R.color.yellow
    }
}