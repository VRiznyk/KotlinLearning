package com.kage.kotlin.ch02

import com.kage.kotlin.ch02.classes.Expr
import com.kage.kotlin.ch02.classes.Expr.*

fun main(args: Array<String>) {
    val expr = Sum(
            Sum(Num(1), Num(2)),
            Num(4)
    )

    println(eval(expr))
    println(evalWhen(expr))
    println(logEval(expr))
}

fun eval(e: Expr): Int {
    if (e is Num) return e.value
    if (e is Sum) return eval(e.left) + eval(e.right)
    else throw IllegalArgumentException("Unknown expression")
}

fun evalWhen(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> evalWhen(e.left) + evalWhen(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}

fun logEval(e: Expr): Int = when (e) {
    is Num -> {
        println("num: ${e.value}")
        e.value
    }
    is Sum -> {
        val left = logEval(e.left)
        val right = logEval(e.right)
        println("sum: $left + $right")
        left + right
    }
    else -> throw IllegalArgumentException("Unknown expression")
}