package year2018.day3

import common.Common
import org.junit.Test

class DayThreeTest {

    var dayThree = DayThree()

    @Test
    fun overlapArea() {
        val claimsInput = listOf(
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2"
        )

        val claims = dayThree.convertImportToClaims(claimsInput)
        val totalAreaOverlap = dayThree.countOverlap(claims)

        kotlin.test.assertEquals(4, totalAreaOverlap)
    }

    @Test
    fun overlapAreaActual() {
        val claimsInput = Common.getFile("day3.txt").readLines()

        val claims = dayThree.convertImportToClaims(claimsInput)
        val totalAreaOverlap = dayThree.countOverlap(claims)

        kotlin.test.assertEquals(101781, totalAreaOverlap)
    }

    @Test
    fun findUnique() {
        val claimsInput = listOf(
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2"
        )

        val claims = dayThree.convertImportToClaims(claimsInput)
        val totalAreaOverlap = dayThree.findNoOverlap(claims)

        kotlin.test.assertEquals(3, totalAreaOverlap)
    }

    @Test
    fun findUniqueActual() {
        val claimsInput = Common.getFile("day3.txt").readLines()

        val claims = dayThree.convertImportToClaims(claimsInput)
        val totalAreaOverlap = dayThree.findNoOverlap(claims)

        kotlin.test.assertEquals(909, totalAreaOverlap)
    }
}
