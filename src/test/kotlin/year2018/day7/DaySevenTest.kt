package year2018.day6

import com.google.common.collect.Table
import common.Common
import org.junit.Test
import year2018.day5.Coord
import year2018.day5.DaySeven
import year2018.day5.DaySixDanger
import year2018.day5.DaySixSafety

class DaySevenTest {
    @Test
    fun findInstructions() {
        val instructions = listOf(
                "Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.",
                "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.",
                "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin."
        )

        val instructionOrder = DaySeven(instructions).order()
        kotlin.test.assertEquals("CABDFE", instructionOrder)
    }

    @Test
    fun findInstructionsActual() {
        val instructions = Common.getFile("year2018/day7.txt").readLines()

        val instructionOrder = DaySeven(instructions).order()
        kotlin.test.assertEquals("GJFMDHNBCIVTUWEQYALSPXZORK", instructionOrder)
    }

    @Test
    fun findConcurrentInstructions() {
        val instructions = listOf(
                "Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.",
                "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.",
                "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin."
        )

        val instructionOrder = DaySeven(instructions).orderConcurrent(2, 0)
        kotlin.test.assertEquals(15, instructionOrder)
    }

    @Test
    fun findConcurrentInstrcutionsActual() {
        val instructions = Common.getFile("year2018/day7.txt").readLines()

        val instructionOrder = DaySeven(instructions).orderConcurrent(5, 60)
        kotlin.test.assertEquals(15, instructionOrder)
    }
}