package com.kage.kotlin.ch02

import com.kage.kotlin.ch02.classes.Person
import com.kage.kotlin.ch02.classes.Rectangle
import java.util.Random


fun main(args: Array<String>) {
    printPerson()
    printRectangle()
}

private fun printPerson() {
    val bob = Person("Bob Dylan")
    println("${bob.name}, married = ${bob.isMarried} ")
    bob.isMarried = true
    println("${bob.name}, married = ${bob.isMarried} ")
}

private fun printRectangle() {
    val rectangle = Rectangle(10, 10)

    println("Rectangle isSquare = ${rectangle.isSquare}")
    println("Rectangle isSquare = ${rectangle.anotherIsSquare}")

    println("Random Rectangle isSquare =${createRandomRectangle().isSquare}")
}

private fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
