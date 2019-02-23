package com.kage.kotlin.ch04

import jdk.nashorn.internal.parser.JSONParser
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

//singleton

data class Person(val name: String, val monthSalary: Int)

object Payroll {
    val allEmployers = arrayListOf<Person>()

    fun calculateSalary(): Int {
        var salary = 0
        for (person in allEmployers) {
            salary += person.monthSalary
        }

        return salary
    }
}

class PayrollTest {

    @Test
    fun payrollTest() {
        Payroll.allEmployers.add(Person("alice", 1000))
        Payroll.allEmployers.add(Person("bob", 2500))

        assertEquals(3500, Payroll.calculateSalary())

        Payroll.allEmployers.clear()
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

class CaseInsensitiveFileComparatorTest {

    @Test
    fun test() {
        assertEquals(
                0,
                CaseInsensitiveFileComparator.compare(
                        File("/User"),
                        File("/user")
                )
        )

        val files = listOf(File("/Z"), File("/a"))
        println(files.sortedWith(CaseInsensitiveFileComparator))
    }
}

//companion

class A {
    companion object {
        fun foo() = println("foo")
    }

    object B {
        fun bar() = println("bar")
    }

    class C {
        fun foobar() = println("foobar")
    }

    fun print() {
        A.foo()
        A.B.bar()

    }
}

class ATest {
    @Test
    fun test() {
        A().print()
        A.C().foobar()
    }
}


class UserX private constructor(val nickname: String) {

    companion object {
        fun newSubscribingUser(email: String) = UserX(email.substringBefore("@"))
    }

}

val userX = UserX.newSubscribingUser("kage@gmail.com")

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class PersonX(val name: String) {
    companion object : JSONFactory<PersonX> {
        override fun fromJSON(jsonText: String): PersonX {
            throw IllegalStateException("Stub")
        }

    }
}

fun <T> loadFromJson(factory: JSONFactory<T>, jsonText: String): T = factory.fromJSON(jsonText)

val person = loadFromJson(PersonX, "{\"name\":\"bob\"}")

//anonymous

interface OnClickListener{
    fun onClick()
}

class ViewX {
    private var onClickListener:OnClickListener? = null

    fun addListener(listener: OnClickListener?){
        onClickListener = listener
    }
}

val unit = ViewX().addListener(object : OnClickListener {
            override fun onClick() {
                println("on click")
            }

        }
)

val listener = object : OnClickListener {
    override fun onClick() {
        println("OnClick")
    }

}
