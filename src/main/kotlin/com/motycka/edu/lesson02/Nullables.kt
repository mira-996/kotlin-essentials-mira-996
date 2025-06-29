package com.motycka.edu.lesson02

fun brewCoffee(coffeeGrams: Double, waterMl: Double, milkMl: Double?, sugarGrams: Double?): String {
    // Determine if coffee is black or with milk
    val milkDescription = if (milkMl != null && milkMl > 0) "with milk" else "black"

    // Determine if coffee is sweetened or unsweetened
    val sugarDescription = if (sugarGrams != null && sugarGrams > 0) "sweetened" else "unsweetened"

    // Format the return string
    return "Coffee ($coffeeGrams g coffee, $waterMl ml water) $milkDescription and $sugarDescription"
}

fun main() {
    // Example usage of brewCoffee function
    val coffee1 = brewCoffee(coffeeGrams = 10.0, waterMl = 200.0, milkMl = null, sugarGrams = null)
    println(coffee1)  // Coffee (10.0 g coffee, 200.0 ml water) black and unsweetened

    val coffee2 = brewCoffee(coffeeGrams = 15.0, waterMl = 250.0, milkMl = 50.0, sugarGrams = 5.0)
    println(coffee2)  // Coffee (15.0 g coffee, 250.0 ml water) with milk and sweetened

    val coffee3 = brewCoffee(coffeeGrams = 20.0, waterMl = 300.0, milkMl = null, sugarGrams = 10.0)
    println(coffee3)  // Coffee (20.0 g coffee, 300.0 ml water) black and sweetened
}
