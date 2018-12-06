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
        val findSleepiestGuardMinute = dayFour.findSleepiestGuardMinuteByGuard(sleeps)


        kotlin.test.assertEquals(240, findSleepiestGuardMinute)
    }

    @Test
    fun guardAndSleepiestMinuteActual() {
        val sleepInput = Common.getFile("year2018/day4.txt").readLines()
        val sleeps = dayFour.createSleepShift(sleepInput)

        val findSleepiestGuardMinute = dayFour.findSleepiestGuardMinuteByGuard(sleeps)


        kotlin.test.assertEquals(39698, findSleepiestGuardMinute)
    }

    @Test
    fun guardAndSleepiestMinuteByMinute() {
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
        val findSleepiestGuardMinute = dayFour.findSleepiestGuardMinuteByMinute(sleeps)


        kotlin.test.assertEquals(4455, findSleepiestGuardMinute)
    }

    @Test
    fun guardAndSleepiestMinuteByMinuteActual() {
        val sleepInput = Common.getFile("year2018/day4.txt").readLines()
        val sleeps = dayFour.createSleepShift(sleepInput)

        val findSleepiestGuardMinute = dayFour.findSleepiestGuardMinuteByMinute(sleeps)


        kotlin.test.assertEquals(14920, findSleepiestGuardMinute)
    }
}