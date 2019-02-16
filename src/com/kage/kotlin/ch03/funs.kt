package com.kage.kotlin.ch03

fun main(args: Array<String>) {

    val valid = User(1, "John", "London")
    val invalid = User(2, "", "")

    try {
        saveUser(valid)
        saveUser(invalid)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }


    try {
        saveUserRefactored(valid)
        saveUserRefactored(invalid)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

data class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Name"
        )
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Address"
        )
    }

    println(user)
}

fun saveUserRefactored(user: User){
    fun validate(value: String, fieldName: String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    println(user)
}