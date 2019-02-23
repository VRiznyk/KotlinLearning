package com.kage.kotlin.ch04

class DelegationCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int get() = innerList.size

    override fun contains(element: T) = innerList.contains(element)

    override fun containsAll(elements: Collection<T>) = innerList.containsAll(elements)

    override fun isEmpty() = innerList.isEmpty()

    override fun iterator() = innerList.iterator()
}

class ProperDelegationCollection<T>(
        private val innerSet: Collection<T> = ArrayList<T>()
) : Collection<T> by innerSet

class CountingSet<T>(private val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var counter = 0

    override fun add(element: T): Boolean {
        counter++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        counter++
        return innerSet.addAll(elements)
    }
}