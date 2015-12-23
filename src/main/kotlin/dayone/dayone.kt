package dayone

import java.io.File

class DayOne {
    fun walkFloors(floorFunctions: String): Int {
        return floorFunctions.map {
            when(it) {
                '(' -> 1
                ')' -> -1
                else -> 0
            }
        }.sum()
    }

    fun findFloorNegOne(floorFunctions: String): Int {
        return findFloorNegOne(floorFunctions, 0)
    }

    tailrec private fun findFloorNegOne(input: String, index: Int, count: Int = 0): Int {
        if (count == -1) {
            return index
        } else if (index == input.length) {
            return 0
        } else {
            val upDown = when(input[index]) {
                '(' -> 1
                ')' -> -1
                else -> 0
            }

            return findFloorNegOne(input, index + 1, count + upDown)
        }
    }
}

fun main(args: Array<String>) {
    val dayoneInput = getFile("dayone_input.txt")
    dayoneInput.forEachLine { println(DayOne().walkFloors(it)) }
    dayoneInput.forEachLine { println(DayOne().findFloorNegOne(it)) }
}

private fun getFile(s: String): File {
    val url: String = ClassLoader.getSystemClassLoader().getResource(s).file
    return File(url)
}