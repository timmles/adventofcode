package year2018.day6

import com.google.common.collect.Table
import common.Common
import org.junit.Test
import year2018.day5.Coord
import year2018.day5.DaySixDanger
import year2018.day5.DaySixSafety

class DaySixTest {
    @Test
    fun findArea() {
        val coordsInput = listOf(
                "1, 1",
                "1, 6",
                "8, 3",
                "3, 4",
                "5, 5",
                "8, 9"
        )

        val maxArea = DaySixDanger(coordsInput).calculateMaxArea()

        kotlin.test.assertEquals(17, maxArea)
    }

    @Test
    fun findAreaActual() {
        val coordsInput = Common.getFile("year2018/day6.txt").readLines()

        val maxArea = DaySixDanger(coordsInput).calculateMaxArea()

        kotlin.test.assertEquals(4754, maxArea)
    }

    @Test
    fun findSafety() {
        val coordsInput = listOf(
                "1, 1",
                "1, 6",
                "8, 3",
                "3, 4",
                "5, 5",
                "8, 9"
        )

        val safeArea = DaySixSafety(coordsInput).calculateSafeRegion(32)

        kotlin.test.assertEquals(16, safeArea)
    }

    @Test
    fun findSafetyActual() {
        val coordsInput = Common.getFile("year2018/day6.txt").readLines()

        val safeArea = DaySixSafety(coordsInput).calculateSafeRegion(10000)

        kotlin.test.assertEquals(4754, safeArea)
    }

    private fun printGrid(coordsArea: Table<Int, Int, Int>, coords: List<Coord>, alt:Int) {
        for (y in (1 - alt)..(9 + alt)) {
            for (x in (1 - alt)..(8 + alt)) {
                val coordsValue = coordsArea[x, y]
                val find = coords.find { it.x == x && it.y == y }

                if (find != null) {
                    print('A' + coordsValue)
                } else if (coordsValue == -1) {
                    print(".")
    //                    print(" ")
                } else {
    //                    print(" ")
                    print('A' + coordsValue)
                }
            }
            println()
        }
    }
}