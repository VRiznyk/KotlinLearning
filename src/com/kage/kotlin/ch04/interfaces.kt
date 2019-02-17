package com.kage.kotlin.ch04


fun main(args: Array<String>) {
    val button = Button()
    button.click()
    button.showOff()
    button.setFocus(true)

    println("|||||||||||||||||||||||||||")

    with(button) {
        click()
        showOff()
        setFocus(false)
    }

}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")
    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
        println("Also, I'm button")
    }

    override fun click() = println("Clicked")
}
