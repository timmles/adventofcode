package year2018.day12

import common.Common
import org.junit.Ignore
import org.junit.Test

class DayTwelveTest {
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

        kotlin.test.assertEquals(325, DayTwelve(initialState, instructions).runGenerations(20))
    }

    @Test
    fun growPlantsActual() {
        val initialState = "#........#.#.#...###..###..###.#..#....###.###.#.#...####..##..##.#####..##...#.#.....#...###.#.####"
        val instructions = Common.getFile("day12.txt").readLines()

        kotlin.test.assertEquals(3217, DayTwelve(initialState, instructions).runGenerations(20))
    }

    @Test
    fun growPlantsRiduculous() {
        val initialState = "#........#.#.#...###..###..###.#..#....###.###.#.#...####..##..##.#####..##...#.#.....#...###.#.####"
        val instructions = Common.getFile("day12.txt").readLines()

        kotlin.test.assertEquals(4_000_000_000_866, DayTwelve(initialState, instructions).runGenerations(50_000_000_000L))
    }
}

