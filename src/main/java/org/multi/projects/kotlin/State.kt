package org.multi.projects.kotlin

enum class State {
    IDLE, RUNNING, FINISHED
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

sealed class Color1 {
    class Red(val value: Int) : Color1()
    class Green(val value: Int) : Color1()
    class Blue(val name: String) : Color1()
}
