@file:JvmName("StringUtils")

package com.kage.kotlin.ch03

const val UNIX_LINE_SEPARATOR = "\n"

var unixLineSeparator = "\n"
    get() = "hello from get"
    set(value) {
        field = "set $value"
    }

@JvmOverloads
fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "(",
        postfix: String = ")"
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}