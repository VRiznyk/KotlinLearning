package com.kage.kotlin.ch02

fun main(args: Array<String>) {
    throwAsExpr()
    println()
    tryAsExpr()
}

fun throwAsExpr() {
    val number = 97
    val percentage = if (number in 0..100)
        number
    else
        throw IllegalArgumentException("A percentage value must be between 0 and 100: Jpercentage")

    println("percentage = $percentage")
}

fun tryAsExpr() {
    val notNumber = try {
        Integer.parseInt("not an number")
    } catch (e: NumberFormatException) {
        -1
    }
    println("NotNumber: $notNumber")

    val number = try {
        Integer.parseInt("2")
    } catch (e: NumberFormatException){
       -1
    }
    println("Number: $number")
}



