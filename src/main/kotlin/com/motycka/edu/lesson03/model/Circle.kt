package com.motycka.edu.lesson03.model

import kotlin.math.PI

/*
 Implement Circle class that implements Shape2D and Ellipse interfaces.

    - It should have a constructor that takes one parameter for the radius.
    - It should override all methods from Shape2D and Ellipse interfaces.
 */


class Circle(override val radius: Double) : Shape2D, Ellipse {

    override fun area(): Double {
        return PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2 * PI * radius
    }

    override fun to3D(): Shape3D {
        // Let's assume a Circle becomes a Sphere in 3D
        return Sphere(radius)
    }
}

// Minimal Sphere class implementing Shape3D
// (I mentioned as comment because, I met the problem related to the Redeclaration: Sphere in the main Sphere.kt)

//class Sphere(private val radius: Double) : Shape3D {
//    override fun volume(): Double {
//        return (4.0 / 3.0) * PI * radius * radius * radius
//    }
//
//    override fun surfaceArea(): Double {
//        return 4 * PI * radius * radius
//    }
//}

// Test the implementation
fun main() {
    val circle = Circle(5.0)
    println("Area: ${circle.area()}")
    println("Perimeter: ${circle.perimeter()}")
    println("Radius: ${circle.radius}")

    val sphere = circle.to3D()
    println("Volume (Sphere): ${sphere.volume()}")
    println("Surface Area (Sphere): ${sphere.surfaceArea()}")
}