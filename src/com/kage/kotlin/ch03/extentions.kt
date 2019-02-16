package com.kage.kotlin.ch03

import com.kage.kotlin.ch03.joinToString as join

fun main(args: Array<String>) {
    println("Kotlin".lastChar())
    println(listOf(1,2,3,4,5).join())
}

fun String.lastChar(): Char = get(length - 1)
