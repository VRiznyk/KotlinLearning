package com.kage.kotlin.ch03

fun main(args: Array<String>) {
    println(list)
    println(list.joinToString( ":","{","}"))
    println(list.joinToString(separator = "; ", postfix = " }", prefix = "{ "))
    println(list.joinToString())
    println(list.joinToString( separator = "::"))
}


val set = hashSetOf(1, 2, 3, 44)
val list = arrayListOf(1, 2, 3, 3, 4)
val map = hashMapOf(1 to "One", 2 to "Two", Pair(3, "Three"))

