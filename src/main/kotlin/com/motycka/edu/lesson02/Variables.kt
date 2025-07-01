package com.motycka.edu.lesson02

/*
Define String variables for two types of coffee: espresso and cappuccino.
 */
const val espresso = "Espresso"
const val cappuccino = "Cappuccino"

/*
Define Double variables for the prices of espresso and cappuccino.
 */
val espressoPrice = 2.5
val cappuccinoPrice = 3.0

fun variables(espressoQuantity: Int, cappuccinoQuantity: Int) {
    val totalPrice: Double = (espressoQuantity * espressoPrice) + (cappuccinoQuantity * cappuccinoPrice)
//    println("Espressos: $espressoQuantity × $$espressoPrice")
//    println("Cappuccinos: $cappuccinoQuantity × $$cappuccinoPrice")
    println(totalPrice)
}

fun main(args: Array<String>) {
    val espressoQuantity = args.count { it.equals(espresso, ignoreCase = true) }
    val cappuccinoQuantity = args.count { it.equals(cappuccino, ignoreCase = true) }

    variables(espressoQuantity = espressoQuantity, cappuccinoQuantity = cappuccinoQuantity)
}
