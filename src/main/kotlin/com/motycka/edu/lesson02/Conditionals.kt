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


//fun conditionals() {
//    val coffeeOrders = mapOf(
//        1 to listOf(ESPRESSO, CAPPUCCINO, LATTE, AMERICANO),
//        2 to listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)
//    )
//
//    coffeeOrders.forEach { orderId, items ->
//
//        println("Processing Order ID: $orderId")
//        println("Items: $items")
//
//        val total: Double = TODO("Calculate total price for the order")
//
//        println("Total price for Order ID $orderId: $total\n")
//    }
//}

// 1. Get price based on item names
fun getItemPrice(item: String): Double {
    return when (item) {
        ESPRESSO -> ESPRESSO_PRICE
        DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
        CAPPUCCINO -> CAPPUCCINO_PRICE
        LATTE -> LATTE_PRICE
        AMERICANO -> AMERICANO_PRICE
        FLAT_WHITE -> FLAT_WHITE_PRICE
        else -> 0.0 // Default for unknown items
    }
}

// 2. Get the lowest price from a list of prices
fun getLowestPrice(prices: List<Double>): Double {
    return prices.minOrNull() ?: 0.0
}

// 3 + 4. Calculate total price for items and apply discount
fun calculateTotalPriceWithDiscount(items: List<String>): Double {
    val prices = items.map { getItemPrice(it) }
    val total = prices.sum()
    return if (items.size >= 3) {
        total - getLowestPrice(prices) // Discount: cheapest item is free
    } else {
        total
    }
}

// 5. Print the total price with a discount applied for each order
fun conditionals() {
    val coffeeOrders = mapOf(
        1 to listOf(ESPRESSO, CAPPUCCINO, LATTE, AMERICANO),
        2 to listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)
    )

    coffeeOrders.forEach { orderId, items ->
        println("Processing Order ID: $orderId")
        println("Items: $items")

        val total: Double = calculateTotalPriceWithDiscount(items)

        println("Total price for Order ID $orderId: $total\n")
    }
}

fun main() {
    conditionals()
}

