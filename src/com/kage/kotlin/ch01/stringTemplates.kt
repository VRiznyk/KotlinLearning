package com.kage.kotlin.ch01

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello, $name!")

    println("\$name")

    println("Hello, ${if (args.isNotEmpty()) args[0] else "someone"}!")
}