package com.motycka.edu.lesson03.model

/*
 Implement Square class that extends the Rectangle class.

    - It should have a constructor that takes one parameter for the side length.
    - It should override all methods from Rectangle class.
    - It should have a method to convert it to a 3D Cuboid with the same side length for width, height, and depth.-
 */

class Square(private val side: Double) : Rectangle(side, side) {

    override fun area(): Double = side * side

    override fun perimeter(): Double = 4 * side

    fun to3D(): Shape3D {
        return Cuboid(side, side, side)
    }
}

fun main() {
    val square = Square(4.0)
    println("Area: ${square.area()}")
    println("Perimeter: ${square.perimeter()}")

    val cube = square.to3D()
    println("Cube Volume: ${cube.volume()}")
    println("Cube Surface Area: ${cube.surfaceArea()}")
}
