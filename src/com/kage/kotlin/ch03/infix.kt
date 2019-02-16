package com.kage.kotlin.ch03

fun main(args: Array<String>) {
    val (letter,number) = "C" with 3
    println(mapOf("A" with 1, "B".with(2), letter with number))
}

infix fun Any.with(other: Any) = Pair(this, other)