package year2018.day13

import common.Common
import org.junit.Test

class DayThirteenTest {
    @Test
    fun simulateTracks() {
        val track = listOf(
                """/->-\        """,
                """|   |  /----\""",
                """| /-+--+-\  |""",
                """| | |  | v  |""",
                """\-+-/  \-+--/""",
                """  \------/   """
        )


        val simulate = DayThirteen(track).simulate()
        kotlin.test.assertEquals(Pair(7,3), simulate.firstCollision)
    }

    @Test
    fun simulateTracksCrash() {
        val track = listOf(
                """/>-<\  """,
                """|   |  """,
                """| /<+-\""",
                """| | | v""",
                """\>+</ |""",
                """  |   ^""",
                """  \<->/"""
        )

        kotlin.test.assertEquals(Pair(6,4), DayThirteen(track).simulate().lastManStanding)
    }

    @Test
    fun growPlantsActual() {
        val track = Common.getFile("year2018/day13.txt").readLines()

        val simulate = DayThirteen(track).simulate()
        kotlin.test.assertEquals(Pair(40,90), simulate.firstCollision)
        kotlin.test.assertEquals(Pair(65, 81), simulate.lastManStanding)

    }
}