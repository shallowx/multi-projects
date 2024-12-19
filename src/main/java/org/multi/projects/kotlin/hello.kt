package org.multi.projects.kotlin

fun main() {
    val contact = Contact(1, "John", "Smith@example.com")
    println(contact.copy())

    val cakes = listOf("cake1", "cake2", "cake3")
    println(cakes)
    println(cakes.containsAll(listOf("cake1", "cake2", "cake3")))
    println(cakes.size)

    for(c in cakes){
        println(c)
    }

    for (i in 1..10) {
        println(i)
    }
    println("-".repeat(20))

    for (i in 1..10 step 2) {
        println(i)
    }
    println("-".repeat(20))

    for (i in 0 until  3) {
        println(i)
    }
    println("-".repeat(20))

    for (i in 10 downTo  0) {
        println(i)
    }
    println("-".repeat(20))

    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")
    println(authors == writers)
    println(authors.javaClass)
    println(writers.javaClass)
    println(writers === authors)
    println("-".repeat(20))

    println(max(1, 3))

    val state = State.RUNNING                         // 2
    val message = when (state) {                      // 3
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)

    val red = Color.RED
    println(red)                                      // 4
    println(red.containsRed())                        // 5
    println(Color.BLUE.containsRed())                 // 6
    println(Color.YELLOW.containsRed())

    val letV = let0(null)
    val length = letV?.let { it.length } ?: 0
    println(letV)
    println(length)
}

fun max(a: Int, b: Int) = if (a > b) a else b

data class User(val id: Int, val name: String, val email: String): Comparable<User> {
    override fun compareTo(other: User): Int {
        return this.email.compareTo(other.email)
    }
}

fun let0(str: String?): String? {
    return str
}