package org.multi.projects.kotlin.tour

fun main() {
   val customer = Customer("jimmy", 1)
   val customer1 = Customer("jimmy", 1)
    println(customer)
    println(customer.age)
    println(customer.name)
    println(customer.equals(customer1))
    println(customer == customer1)
    println(customer.hashCode())
    println(customer1.hashCode())
    println(customer.copy() == customer)
    println(customer.compute())

    val map = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    for((key, value) in map) {
        println("$key -> $value")
    }

    val str = "jimmy little"
    println(str)
    println(str?.length ?: 100)
}

data class Customer(val name: String, override var age: Int): MyAbstractClass() {
    fun compute(): String {
        return "$name, $age"
    }

    override fun doSomething() {
        TODO("Not yet implemented")
    }
}

fun Customer.max(): Int {
    return this.age
}

@JvmInline
value class User(val name: String)

abstract class MyAbstractClass {
    abstract var age: Int
    abstract fun doSomething()
}