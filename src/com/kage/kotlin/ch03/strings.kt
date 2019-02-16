package com.kage.kotlin.ch03

fun main(args: Array<String>) {
    println("192.168.1.1".split("."))
    println("192.168.1.1".split("\\.".toRegex()))
    println("192.168.1.1/24".split(".", "/"))

    parsePath("/system/apk/launcher.apk")
    parsePathWithRegExp("/system/apk/launcher.apk")
    println(KOTLIN_LOGO)
}

fun parsePath(path: String){
    val dir = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val ext = fullName.substringAfterLast(".")

    println("Dir: $dir, name: $fileName, ext: $ext")
}

fun parsePathWithRegExp(path: String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null){
        val (dir, fileName, ext) = matchResult.destructured
        println("Dir: $dir, name: $fileName, ext: $ext")

    }
}

const val KOTLIN_LOGO = """
    | //
    |//
    |/ \
"""

val price1 = """${'$'}99.99"""
val price2 = "$99.99"