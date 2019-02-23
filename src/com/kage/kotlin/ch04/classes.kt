package com.kage.kotlin.ch04

class Outer {
    inner class Inner {
        fun getOuterRef(): Outer = this@Outer
    }

    class Nested {}
}

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int = when (e) {
    is Expr.Num -> e.value
    is Expr.Sum -> eval(e.left) + eval(e.right)
}

class User1(val name: String)

class User2 constructor(name: String) {
    val name: String

    init {
        this.name = name
    }
}

class User3(_name: String) {
    val name = _name
}

class User4(val name: String)

open class User5(var name: String = "John Smith")

val user = User5(name = "Alice")

val userByDefault = User5()

class TwitterUser(name: String) : User5(name) {
    init {
        this.name = "Twitter:$name"
    }
}

class Secretive private constructor()

//----------------------------------------------

interface Context

interface AttributeSet


open class View {
    constructor(ctx: Context):this(ctx, null)

    constructor(ctx: Context, attr: AttributeSet?)
}


class MyButton: View {

    constructor(ctx: Context):super(ctx)

    constructor(ctx: Context,attr: AttributeSet):super(ctx, attr)
}


































