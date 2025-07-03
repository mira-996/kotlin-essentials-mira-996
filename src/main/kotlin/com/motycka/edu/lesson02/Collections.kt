package com.motycka.edu.lesson02

/*
 Coffee Shop Menu
 */

const val ESPRESSO = "Espresso"
const val DOUBLE_ESPRESSO = "Double Espresso"
const val CAPPUCCINO = "Cappuccino"
const val LATTE = "Latte"
const val MACCHIATO = "Macchiato"
const val MOCHA = "Mocha"
const val FLAT_WHITE = "Flat White"
const val AMERICANO = "Americano"


//val coffeeMenu: List<String> = TODO("Initialize the list")
//
//fun collections() {
//    val orders: Map<Int, List<String>> = TODO("Define a mutable map to store orders")
//
//    println("\nWelcome to the Coffee Shop! Here is our menu:")
//
//    // TODO print the coffee menu items
//
//    // TODO create orders
//
//    println("\nOrders placed:")
//    orders.forEach {
//        println("Order ID: ${it.key}, Items: ${it.value}")
//    }
//}


/*
    1. Create a list to store coffee menu items
    2. Initialize the list with constants defined above
 */
val coffeeMenu: List<String> = listOf(
    ESPRESSO,
    DOUBLE_ESPRESSO,
    CAPPUCCINO,
    LATTE,
    MACCHIATO,
    MOCHA,
    FLAT_WHITE,
    AMERICANO
)

fun collections() {
    // 3. Define a mutable map to store orders, use: mutableMapOf<Int, List<String>>()
    val orders: MutableMap<Int, List<String>> = mutableMapOf()

    println("\nWelcome to the Coffee Shop! Here is our menu:")

    // 4. Print the coffee menu items
    coffeeMenu.forEachIndexed { index, item ->
        println("${index + 1}. $item")
    }

    // 5. Create order1 with, 1x ESPRESSO, 2x CAPPUCCINO, and 1x AMERICANO
    val order1 = listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO)

    // 6. Add order 1 to orders map
    orders[1] = order1

    // 7. Create order2 with, 1x ESPRESSO, 1x DOUBLE_ESPRESSO, and 1x FLAT_WHITE
    val order2 = listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)

    // 8. Add order 2 to orders map
    orders[2] = order2

    // 9. Print the orders placed, uncomment the println statement at the end
    println("\nOrders placed:")
    orders.forEach { (id, items) ->
        println("Order ID: $id")
        items.forEach { println("- $it")}
    }
}


fun main() {
    collections()
}
