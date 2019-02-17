package com.kage.kotlin.ch04

fun main(args: Array<String>) {

}

open class RichButton : Clickable, Focusable { //Java:non-final

    fun disable() {} // Java:final

    open fun animate() {} //Java:non-final

    override fun click() {} //Java:@Override

    final override fun showOff() {} //Java:final
}

abstract class Animated {

    abstract fun animate()

    open fun stopAnimation() {}

    fun animateTwice(){}

}


internal open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk")
}

// fun TalkativeButton.giveSpeech(){} - not compiled