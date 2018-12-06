package year2018.day4

import common.Common
import org.junit.Test

class DayFourTest {

    var dayFour = DayFour()

    @Test
    fun guardAndSleepiestMinute() {
        val sleepInput = listOf(
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-05 00:45] falls asleep",
                "[1518-11-05 00:55] wakes up"
        )

        val sleeps = dayFour.createSleepShift(sleepInput)
        val findSleepiestGuardMinute = dayFour.findSleepiestGuardMinute(sleeps)


        kotlin.test.assertEquals(240, findSleepiestGuardMinute)
    }

    @Test
    fun guardAndSleepiestMinuteActual() {
        val sleepInput = Common.getFile("year2018/day4.txt").readLines()
        val sleeps = dayFour.createSleepShift(sleepInput)

        val findSleepiestGuardMinute = dayFour.findSleepiestGuardMinute(sleeps)


        kotlin.test.assertEquals(39698, findSleepiestGuardMinute)
    }

//    @Test
//    fun findUnique() {
//        val claimsInput = listOf(
//                "#1 @ 1,3: 4x4",
//                "#2 @ 3,1: 4x4",
//                "#3 @ 5,5: 2x2"
//        )
//
//        val claims = dayThree.convertImportToClaims(claimsInput)
//        val totalAreaOverlap = dayThree.findNoOverlap(claims)
//
//        kotlin.test.assertEquals(3, totalAreaOverlap)
//    }
//
//    @Test
//    fun findUniqueActual() {
//        val claimsInput = Common.getFile("year2018/day3.txt").readLines()
//
//        val claims = dayThree.convertImportToClaims(claimsInput)
//        val totalAreaOverlap = dayThree.findNoOverlap(claims)
//
//        kotlin.test.assertEquals(909, totalAreaOverlap)
//    }
}