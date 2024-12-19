package org.multi.projects.kotlin

fun main(args: Array<String>) {
    println("hello world")
    printMessage("hello world - unit")
    printMessageWithPrefix("hello world - ", prefix = "INFO")
    printMessageWithPrefix("hello", "world", prefix = "WARN")
    println(sum(1, 2))
    println(multiply(1, 2))
    val sum = 1 plus 2
    println(sum)

    val a: String = "string"
    println(a)
    val b: Int = 1
    println(b)

    val c: Char = 'c'
    println(c)

    val customer = Customer()
    println(customer)

    val contact = Contact(1, "jimmy", "jimmy@gmail.com")
    println(contact)
    println(contact.javaClass)
    println(contact.id)
    println(contact.name)
    println(contact.print())

    println("--".repeat(20))

    val mutableStack = MutableStack("hello","world")
    println(mutableStack.toString())
    println(mutableStack.size())
}

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(vararg message: String, prefix: String = "debug") {
    println(message.size)
    for(m in message) {
        println("[$prefix] $m")
    }
}

fun sum(a:Int, b: Int):Int {return a + b}

fun multiply(a:Int, b:Int) = a * b

infix fun Int.plus(other: Int): Int {
    return this + other
}

class Customer
open class ExtendsAble(private var pname: String?, var page: Int?) {
   constructor(): this(null, null)
   open fun print() {
        println("parent: $pname $page")
    }
}

data class Contact(val id: Int, var name: String, private val email: String): ExtendsAble(){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }
}

class MutableStack<E>(vararg elements: E) {
    private val elements = elements.toMutableList()

    fun push(element: E) {
        elements.add(element)
    }

    fun pop(): E {
        return elements.removeAt(elements.size - 1)
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}