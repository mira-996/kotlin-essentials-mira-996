

package com.motycka.edu.lesson02

val coffeeOrders = mutableMapOf<Int, List<String>>()
var orderCounter = 1

fun main() {
    // You can write code here to try the functions
    println("Change: ${processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)}")
    println("Change: ${processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)}")
    // println("Change: ${processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0)}") // will fail due to insufficient payment
}

/* Implement the functions below */

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placeOrder(items) // call placeOrder(items)
    val totalToPay = payOrder(orderId) // call payOrder(orderId)

    val change = payment - totalToPay // calculate change

    if (change < 0) {
        throw IllegalArgumentException("Insufficient payment: required $totalToPay, provided $payment")
    }

    completeOrder(orderId) // call completeOrder(orderId)

    return change
}

// Implement placeOrder
fun placeOrder(items: List<String>): Int {
    val id = orderCounter++
    coffeeOrders[id] = items
    println("Placed order $id: $items")
    return id
}

// Implement payOrder
fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: throw IllegalArgumentException("Order ID $orderId not found")
    val prices = items.map { getPrice(it) }
    val total = prices.sum()

    return if (items.size >= 3) {
        total - (prices.minOrNull() ?: 0.0)
    } else {
        total
    }
}

// Implement completeOrder
fun completeOrder(orderId: Int) {
    coffeeOrders.remove(orderId)
    println("Order $orderId completed and removed.")
}


