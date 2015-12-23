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
        var floor: Int = 0;

        floorFunctions.forEachIndexed { index, char ->
            when(char) {
                '(' -> floor++
                ')' -> floor--
            }

            if (floor == -1) {
                return index + 1
            }
        }

        return 0
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