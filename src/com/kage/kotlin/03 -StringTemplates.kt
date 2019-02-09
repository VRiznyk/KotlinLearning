package com.kage.kotlin

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello, $name!")

    println("\$name")

    println("Hello, ${if (args.isNotEmpty()) args[0] else "someone"}!")
}