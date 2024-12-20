package org.multi.projects.kotlin.tour

fun main(args: Array<String>) {
    println("hello world")
    println(args.contentToString())

    val extendsAble2 = ExtendsAble2("127.0.0.1:8080")
    println(extendsAble2.toString())
    println(extendsAble2.name)
    println(extendsAble2.age)
    println(extendsAble2.addr)

    val items = mutableListOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
        println(items.lastIndex)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    println(items.size)
    println(items.lastIndex)

    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println(x)
    }

    val sb = StringBuilder()
    for (k in 1..10) {
        sb.append(k)
    }
    println(sb.toString())
}

open class ExtendsAble
class ExtendsAble2(val addr: String): ExtendsAble(){
    val name: String
        get() {
            return this.javaClass.simpleName
        }
    val age: Int
        get() {
            return 1
        }
}