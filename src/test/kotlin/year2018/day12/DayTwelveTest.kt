package year2018.day12

import common.Common
import org.junit.Test

class DayTwelveTest {
//    @Test
//    fun testToInt() {
//        val dayTwelve = DayTwelve("...##....#####...#######....#.#..##.", listOf())
//
//        kotlin.test.assertEquals(325, dayTwelve.toInt())
//    }

    @Test
    fun growPlants() {
        val initialState = "#..#.#..##......###...###..........."
        val instructions = listOf(
                "...## => #",
                "..#.. => #",
                ".#... => #",
                ".#.#. => #",
                ".#.## => #",
                ".##.. => #",
                ".#### => #",
                "#.#.# => #",
                "#.### => #",
                "##.#. => #",
                "##.## => #",
                "###.. => #",
                "###.# => #",
                "####. => #"
        )

        val dayTwelve = DayTwelve(initialState, instructions)
        dayTwelve.runGenerations(20)

        kotlin.test.assertEquals(325, dayTwelve.toInt())
    }

    @Test
    fun growPlantsActual() {
        val initialState = "#........#.#.#...###..###..###.#..#....###.###.#.#...####..##..##.#####..##...#.#.....#...###.#.####"
        val instructions = Common.getFile("year2018/day12.txt").readLines()

        val dayTwelve = DayTwelve(initialState, instructions)
        dayTwelve.runGenerations(20)

        kotlin.test.assertEquals(3217, dayTwelve.toInt())
    }

    @Test
    fun growPlantsRiduculous() {
        val initialState = "#........#.#.#...###..###..###.#..#....###.###.#.#...####..##..##.#####..##...#.#.....#...###.#.####"
        val instructions = Common.getFile("year2018/day12.txt").readLines()

        val dayTwelve = DayTwelve(initialState, instructions)
        dayTwelve.runGenerations(50_000_000_000L)

        kotlin.test.assertEquals(3217, dayTwelve.toInt())
    }
}

