package com.kage.kotlin.ch02

import java.util.Random

private class Person(
        val name: String,
        var isMarried: Boolean
)


private class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }

    val anotherIsSquare = height == width
}

private fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main(args: Array<String>) {
    val bob = Person("Bob Dylan", false)
    println("${bob.name}, married = ${bob.isMarried} ")
    bob.isMarried = true
    println("${bob.name}, married = ${bob.isMarried} ")

    val rectangle = Rectangle(10, 10)

    println(rectangle.isSquare)
    println(rectangle.anotherIsSquare)

    println(createRandomRectangle().isSquare)


}