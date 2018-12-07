package year2018.day5

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import kotlin.math.abs

class DaySixDanger(coordsInput: List<String>) {

    val coords:List<Coord>

    init {
        var id = 0
        this.coords = coordsInput.map {
            val split = it.split(", ")
            Coord(id++, split[0].toInt(),split[1].toInt())
        }

        this.coords.forEach {current ->
            val x1 = coords.filter { it.x < current.x }
            val x2 = coords.filter { it.x > current.x }
            val y1 = coords.filter { it.y < current.y }
            val y2 = coords.filter { it.y > current.y }
        }

        this.coords
    }


    fun calculateMaxArea(): Int {
        val gridSize = gridSize(coords)

        val maxAreaFirst = maxArea(coords, gridSize, 10)
        val maxAreaSecond = maxArea(coords, gridSize, 50)

        return maxAreaFirst.filter { first ->
            val secondValue = maxAreaSecond[first.key]
            first.value == secondValue
        }.values.max()!!

    }

    private fun maxArea(coords: List<Coord>, gridSize: Grid, deviation: Int): Map<Int, Int> {
        val (x1, x2, y1, y2) = gridSize
        val coordsGridFirst = createCoordGrid(coords, x1 - deviation, x2 + deviation, y1 - deviation, y2 + deviation)
        return coordsByArea(coords, coordsGridFirst)
    }

    private fun gridSize(coords: List<Coord>): Grid {
        return Grid(
                coords.minBy { it.x }!!.x,
                coords.maxBy { it.x }!!.x,
                coords.minBy { it.y }!!.y,
                coords.maxBy { it.y }!!.y
        )
    }

    fun createCoordGrid(coords: List<Coord>, minX: Int, maxX: Int, minY: Int, maxY: Int): Table<Int, Int, Int> {
        val table = HashBasedTable.create<Int, Int, Int>()

        for (x in minX..maxX) {
            for (y in minY..maxY) {
                table.put(x, y, findNearest(coords, x, y))
            }
        }

        return table
    }

    private fun findNearest(coords: List<Coord>, x: Int, y: Int): Int {
        val sortedBy = coords
                .map { Pair(it, abs(it.x - x) + abs(it.y - y)) }
                .sortedBy { it.second }

        if (sortedBy[0].second == sortedBy[1].second) {
            return -1
        } else {
            return sortedBy[0].first.id
        }
    }

    fun coordsByArea(coords: List<Coord>, coordsGrid: Table<Int, Int, Int>): MutableMap<Int, Int> {
        val coordsByArea: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

        coordsGrid.values().forEach {
            val coordCounts = coordsByArea.getOrPut(it, {0})
            coordsByArea.put(it, coordCounts + 1)
        }

        return coordsByArea
    }

}

class DaySixSafety(coordsInput: List<String>) {

    val coords:List<Coord>

    init {
        var id = 0
        this.coords = coordsInput.map {
            val split = it.split(", ")
            Coord(id++, split[0].toInt(),split[1].toInt())
        }

        this.coords.forEach {current ->
            val x1 = coords.filter { it.x < current.x }
            val x2 = coords.filter { it.x > current.x }
            val y1 = coords.filter { it.y < current.y }
            val y2 = coords.filter { it.y > current.y }
        }

        this.coords
    }


    fun calculateSafeRegion(safetyThreshold: Int): Int {
        val (x1, x2, y1, y2) = gridSize(coords)
        val coordsGrid = createCoordGrid(coords, x1, x2, y1, y2)
        return coordsBySafety(coords, coordsGrid, safetyThreshold)
    }

    private fun gridSize(coords: List<Coord>): Grid {
        return Grid(
                coords.minBy { it.x }!!.x,
                coords.maxBy { it.x }!!.x,
                coords.minBy { it.y }!!.y,
                coords.maxBy { it.y }!!.y
        )
    }

    fun createCoordGrid(coords: List<Coord>, minX: Int, maxX: Int, minY: Int, maxY: Int): Table<Int, Int, Int> {
        val table = HashBasedTable.create<Int, Int, Int>()

        for (x in minX..maxX) {
            for (y in minY..maxY) {
                table.put(x, y, sumDistanceToSiblings(coords, x, y))
            }
        }

        return table
    }

    private fun sumDistanceToSiblings(coords: List<Coord>, x: Int, y: Int): Int {
        return coords.sumBy { abs(it.x - x) + abs(it.y - y) }
    }

    fun coordsBySafety(coords: List<Coord>, coordsGrid: Table<Int, Int, Int>, safetyThreshold: Int): Int {
        val coordsByArea: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

        return coordsGrid.values().filter { it < safetyThreshold }.count()
    }

}

data class Coord (
        val id: Int,
        val x: Int,
        val y: Int
)

data class Grid (
        val x1:Int,
        val x2:Int,
        val y1:Int,
        val y2:Int
)