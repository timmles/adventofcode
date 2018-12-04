package year2015.day3

import common.Common
import java.util.*

fun main(args: Array<String>) {
    val daythreeInput = Common.getFile("daythree_input.txt")

    daythreeInput.forEachLine {
        var index = 0
        var partition = it.partition { index++ % 2 == 0 }

        val neigh = Neighbourhood()
        neigh.deliverPresents(it)

        val neighWithRobo = Neighbourhood()
        neighWithRobo.deliverPresents(partition.first)
        neighWithRobo.deliverPresents(partition.second)

        println("countHouses: " + neigh.countHouses())
        println("countHousesWithRoboSanta: " + neighWithRobo.countHouses())
    }
}

data class Point(val x: Int, val y: Int)

class Neighbourhood {
    var map = HashMap<Point, Int>()

    fun deliverPresents(moves: String) {
        var current = Point(0, 0)

        map.set(current, map.getOrDefault(current, 0) + 1)

        moves.forEach {
            current = when(it) {
                '>' -> Point(current.x + 1, current.y)
                '<' -> Point(current.x - 1, current.y)
                '^' -> Point(current.x, current.y + 1)
                'v' -> Point(current.x, current.y - 1)
                else -> Point(0, 0)
            }

            map.set(current, map.getOrDefault(current, 0) + 1)
        }
    }

    fun countHouses(): Int {
        return map.count();
    }
}