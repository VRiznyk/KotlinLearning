package com.kage.kotlin.ch05

import org.junit.Test

class LambdasTest {
    @Test
    fun test() {
        val sum = { x: Int, y: Int -> x + y }

        println(sum(1, 1)) //2

        val run = { println(23) }() //23

        println(run) //kotlin.Unit

        run { println(42) } //42
    }
}

//-------------------

data class Person(val name: String, val age: Int)

fun findOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null

    for (person in people) {
        if (person.age > maxAge)
            theOldest = person
    }

    println(theOldest)
}

fun separator() = println("--------------------------------------")

class PersonSearchTest {
    @Test
    fun test() {
        val people = listOf(Person("Alice", 14), Person("Bob", 42))

        findOldest(people)

        println(people.maxBy({ person: Person -> person.age }))

        println(people.maxBy { person: Person -> person.age })

        println(people.maxBy { person -> person.age })

        println(people.maxBy { it.age })

        println(people.maxBy(Person::age))

        val names = people.joinToString(separator = ";", transform = { it.name })

        println(names)


        separator()
        run(::separator)
    }

}
