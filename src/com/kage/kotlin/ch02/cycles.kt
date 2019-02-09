package com.kage.kotlin.ch02

import java.util.*


fun main(args: Array<String>) {
    cycleWhile()
    println()
    cycleDoWhile()
    println()
    cycleFor()
    println()
    printFizzBuzz()
    println()
    printMap()
    println()
    printList()
    println()
    printCheckRanges()
    println()
}

fun printFizzBuzz() {
    println("FizzBuzz Game")
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()
}

fun cycleWhile() {
    var i = 10
    while (i >= 0) {
        println("[while] Countdown: $i")
        i--
    }
}

fun cycleDoWhile() {
    var i = 10
    do {
        println("[do while] Countdown: $i")
    } while (--i >= 0)
}

fun cycleFor() {
    for (i in 10 downTo 0) {
        println("[for] Countdown: $i")
    }
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun printMap() {
    val binaryReps = TreeMap<Char,String>()

    for(char in 'A'..'Z'){
        val binary = Integer.toBinaryString(char.toInt())
        binaryReps[char] = binary
    }

    for((letter, binary) in binaryReps){
        println("$letter = $binary")
    }
}

fun printList() {
    val list = arrayListOf("10","11","101")
    for ((index,element) in list.withIndex()){
        println("$index = $element")
    }
}

fun printCheckRanges() {
    val x = 'X'
    println("$x is letter = ${isLetter(x)}")
    println("$x is digit = ${!isNotDigit(x)}")
    println("$x recognize: ${recognize(x)}")
}

fun isLetter(c:Char) = c in 'a'..'z'||c in 'A'..'Z'

fun isNotDigit(c:Char) = c !in '0'..'9'

fun recognize(c:Char) = when (c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}


