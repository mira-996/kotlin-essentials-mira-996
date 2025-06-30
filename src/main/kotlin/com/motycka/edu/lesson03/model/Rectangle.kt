package com.motycka.edu.lesson03.model

/*
 Implement Rectangle class that implements Shape2D and Quadrilateral interfaces.
    - It should have a constructor that takes two parameters for width and length.
    - It should override all methods from Shape2D and Quadrilateral interfaces
 */

open class Rectangle(
    override val width: Double,
    override val length: Double
) : Shape2D, Quadrilateral {

    override fun area(): Double = width * length

    override fun perimeter(): Double = 2 * (width + length)

    override fun to3D(depth: Double): Shape3D {
        return Cuboid(width, length, depth)
    }
}

fun main() {
    val rect = Rectangle(4.0, 5.0)
    println("Area: ${rect.area()}")
    println("Perimeter: ${rect.perimeter()}")

    val cuboid = rect.to3D(3.0)
    println("Cuboid Volume: ${cuboid.volume()}")
    println("Cuboid Surface Area: ${cuboid.surfaceArea()}")
}