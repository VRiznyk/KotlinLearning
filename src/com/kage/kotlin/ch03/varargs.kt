package com.kage.kotlin.ch03

fun main(args: Array<String>) {
    val strings = arrayOf("a","b","c")
    val list = listOf("strings: ", *strings)
    println(list)
}