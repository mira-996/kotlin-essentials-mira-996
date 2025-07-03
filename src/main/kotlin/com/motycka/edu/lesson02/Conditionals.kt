package com.motycka.edu.lesson02

//const val ESPRESSO = "Espresso"
//const val DOUBLE_ESPRESSO = "Double Espresso"
//const val CAPPUCCINO = "Cappuccino"
//const val LATTE = "Latte"
//const val MACCHIATO = "Macchiato"
//const val MOCHA = "Mocha"
//const val FLAT_WHITE = "Flat White"
//const val AMERICANO = "Americano"

const val ESPRESSO_PRICE = 2.5
const val DOUBLE_ESPRESSO_PRICE = 3.0
const val CAPPUCCINO_PRICE = 3.0
const val LATTE_PRICE = 3.5
const val AMERICANO_PRICE = 2.0
const val FLAT_WHITE_PRICE = 3.2

val orders = mutableMapOf<Int, List<String>>()

// 1. Get price based on item names
fun getItemPrice(item: String): Double {
    return when (item) {
        ESPRESSO -> ESPRESSO_PRICE
        DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
        CAPPUCCINO -> CAPPUCCINO_PRICE
        LATTE -> LATTE_PRICE
        AMERICANO -> AMERICANO_PRICE
        FLAT_WHITE -> FLAT_WHITE_PRICE
        else -> 0.0
    }
}
// 2. Get the lowest price from a list of prices
fun getLowestPrice(prices: List<Double>): Double = prices.minOrNull() ?: 0.0

//3 + 4. Calculate total price for items and apply discount
fun calculateTotalPriceWithDiscount(items: List<String>): Double {
    val prices = items.map { getItemPrice(it) }
    val total = prices.sum()
    return if (items.size >= 3) total - getLowestPrice(prices) else total
}
//5. Print the total price with a discount applied for each order
fun conditionals() {
    orders[1] = listOf(ESPRESSO, CAPPUCCINO, LATTE, AMERICANO)
    orders[2] = listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)

    orders.forEach { orderId, items ->
        println("Processing Order ID: $orderId")
        println("Items: $items")
        val total = calculateTotalPriceWithDiscount(items)
        println("Total price for Order ID $orderId: $total\n")
    }
}

fun main() {
    conditionals()
}
