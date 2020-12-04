package year2018.day11

import com.google.common.collect.HashBasedTable

class DayEleven(val serialNumber: Int) {

    val grid = HashBasedTable.create<Int, Int, Int>() //value, point

    init {
        for (x in 1..300) {
            for (y in 1..300) {
                val calculatePower = calculatePower(x, y)
                val left = getfromGridOrZero(x - 1, y)
                val up = getfromGridOrZero(x, y - 1)
                val upLeft = getfromGridOrZero(x - 1, y - 1)

                grid.put(x, y, calculatePower + left + up - upLeft)
            }
        }
    }

    fun getfromGridOrZero(x: Int, y: Int): Int {
        val gridValue = grid[x, y]
        return if (gridValue == null) 0 else gridValue
    }

    fun calculatePower(x: Int, y: Int): Int {
        val rackId = x + 10
        var powerLevel = rackId * y
        powerLevel += serialNumber
        powerLevel *= rackId
        powerLevel = powerLevel / 100 % 10
        return powerLevel - 5
    }

    private fun hundredsOnly(powerLevel: Int): Int {
        val toString = powerLevel.toString()
        return toString.getOrElse(toString.length - 3,{ '0' }).toString().toInt()
    }

    fun searchLargestVariable(): Point {
        val relativePower = mutableListOf<Point>()

        for (x in 1..300) {
            val element = searchLargest(x)
            relativePower.add(Point(element.first, element.second, element.third, x))
        }

        return relativePower.maxBy { it.value }!!
    }

    fun searchLargest(gridSize: Int): Triple<Int, Int, Int> {
        val relativePower = HashBasedTable.create<Int, Int, Int>()

        for (x in 1..300) {
            for (y in 1..300) {
                val Ax = x
                val Ay = y

                val Bx = x + gridSize
                val By = y

                val Cx = x
                val Cy = y + gridSize

                val Dx = x + gridSize
                val Dy = y + gridSize

                if (greaterThan(Ax, Ay, Bx, By, Cx, Cy, Dx, Dy, number=300-gridSize)) {
                    relativePower.put(x, y, 0)
                } else {
                    relativePower.put(x, y, grid[Dx,Dy] + grid[Ax,Ay] - grid[Bx,By] - grid[Cx,Cy])
                }
            }
        }

        val maxValue = relativePower.values().max()!!

        for (x in 1..300) {
            for (y in 1..300) {
                if (relativePower[x, y] == maxValue) {
                    return Triple(x+1, y+1, maxValue)
                }
            }
        }

        throw Error("wat")
    }

    fun greaterThan(vararg vals: Int, number: Int): Boolean {
        val map = vals.map { it > number }
        val reduce = map.reduce { acc, b -> acc || b }
        return reduce
    }
}

data class Point(
        val x: Int,
        val y: Int,
        val value: Int,
        val grid: Int)