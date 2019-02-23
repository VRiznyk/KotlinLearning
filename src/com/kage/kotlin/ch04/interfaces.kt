package com.kage.kotlin.ch04

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

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

class ButtonTest {

    @Test
    fun buttonTest() {
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
}


//---------------------------------------------------------------------

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "kage"
    }

}

interface AnotherUser {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class YetAnotherUser(val nickname: String) {
    var address: String = "undefined"
        set(value) {
            println("""
                Address was changed for $nickname
                "$field" -> "$value"
            """.trimIndent())
        }
        get() {
            println("getter called")
            return field
        }
}

class YetAnotherUserTest {

    @Test
    fun test() {
        val user = YetAnotherUser("Carl")

        user.address = "London"
        user.address
    }
}

//-----------------------------------------------------

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}


class LengthCounterTest {
    @Test
    fun privateSetterTest() {
        val lengthCounter = LengthCounter()
        lengthCounter.addWord("Hello!")
        println(lengthCounter.counter)
    }
}

//----------------------------------------------------

class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + postalCode
    }

    override fun toString() = "Client(name=$name, postalCode=$postalCode"
}


data class DataClient(val name: String, val postalCode: Int)

class ClientTest {

    @Test
    fun clientTest() {

        val adam = Client("adam", 1111)
        val adamClone = Client("adam", 1111)
        val eva = Client("eva", 2222)

        assertEquals(adam, adamClone)
        assertNotEquals(adam, eva)

        val bob = DataClient("bob", 3333)
        val bobClone = DataClient("bob", 3333)
        val alice = DataClient("alice", 4444)

        assertEquals(bob, bobClone)
        assertNotEquals(bob, alice)

        val mutatedBob = bob.copy(name = "mutatedBob")
        println(mutatedBob)

    }

}












































