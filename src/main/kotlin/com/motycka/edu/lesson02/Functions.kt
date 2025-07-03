package com.motycka.edu.lesson02


val coffeeOrders = mutableMapOf<Int, List<String>>()
var currentOrderId = 1

fun main() {
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0) // Will fail due to insufficient payment
}

// Full order processing flow
fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placeOrder(items)
    val totalToPay = payOrder(orderId)

    if (payment < totalToPay) {
        println("Order ID $orderId: Payment of $$payment is insufficient. Total needed: $$totalToPay")
        coffeeOrders.remove(orderId)
        return -1.0
    }

    val change = payment - totalToPay

    completeOrder(orderId)

    println("Order ID $orderId completed. Change returned: $$change\n")
    return change
}

// TODO Implement placerOrder(items: List<String>): Int
fun placeOrder(items: List<String>): Int {
    coffeeOrders[currentOrderId] = items
    println("Placed Order ID $currentOrderId: $items")
    return currentOrderId++
}

// TODO Implement payOrder(orderId: Int): Double
fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: throw IllegalArgumentException("Order not found")
    return calculateTotalPriceWithDiscount(items) // applies discount
}

// TODO Implement completeOrder(orderId: Int)
fun completeOrder(orderId: Int) {
    if (!coffeeOrders.containsKey(orderId))
        throw IllegalArgumentException("Order does not exist")
    coffeeOrders.remove(orderId)
}

