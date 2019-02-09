package com.kage.kotlin.ch02.classes

class Rectangle(val height: Int, val width: Int){
    val isSquare: Boolean
        get() {
            return height == width
        }

    val anotherIsSquare = height == width
}

