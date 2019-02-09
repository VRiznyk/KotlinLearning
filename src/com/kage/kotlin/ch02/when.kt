package com.kage.kotlin.ch02

import com.kage.kotlin.ch02.classes.Color
import com.kage.kotlin.ch02.classes.Color.*

fun main(args: Array<String>) {
    println(Color.BLUE.rgb())

    println(getMnemonic(Color.GREEN))

    println(getWarmth(Color.INDIGO))

    println(mix(BLUE, VIOLET))

    try {
        println(mix(BLUE, GREEN))
    } catch (e: Exception) {
        e.printStackTrace()
    }

    println(mixOptimized(BLUE,VIOLET))

    try {
        println(mixOptimized(BLUE, GREEN))
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun getMnemonic(color: Color) = when (color) {
    RED -> "Каждый"
    ORANGE -> "Охотник"
    YELLOW -> "Желает"
    GREEN -> "Знать"
    BLUE -> "Где"
    INDIGO -> "Сидит"
    VIOLET -> "Фазан"
}

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "Warm"
    Color.GREEN -> "Neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "Cold"
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    setOf(BLUE, VIOLET) -> INDIGO
    else -> throw Exception("Dirty color")
}

fun mixOptimized(c1: Color, c2: Color) = when {
    c1 == RED && c2 == YELLOW || c1 == YELLOW && c2 == RED -> ORANGE
    c1 == BLUE && c2 == YELLOW || c1 == YELLOW && c2 == BLUE -> GREEN
    c1 == BLUE && c2 == VIOLET || c1 == VIOLET && c2 == BLUE -> INDIGO
    else -> throw Exception("Dirty color")
}