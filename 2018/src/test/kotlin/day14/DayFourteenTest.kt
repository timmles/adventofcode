package year2018.day14

import org.junit.Ignore
import org.junit.Test

class DayFourteenTest {

    @Test
    fun recipesByGeneration() {
        kotlin.test.assertEquals("5158916779", DayFourteen().improveRecipe(9))
        kotlin.test.assertEquals("0124515891", DayFourteen().improveRecipe(5))
        kotlin.test.assertEquals("9251071085", DayFourteen().improveRecipe(18))
        kotlin.test.assertEquals("5941429882", DayFourteen().improveRecipe(2018))
        kotlin.test.assertEquals("2615161213", DayFourteen().improveRecipe(909441))
    }

    @Test
    fun recipesByOutput() {
        kotlin.test.assertEquals(9 , DayFourteen().improveRecipe2("51589"))
        kotlin.test.assertEquals(5 , DayFourteen().improveRecipe2("01245"))
        kotlin.test.assertEquals(18 , DayFourteen().improveRecipe2("92510"))
        kotlin.test.assertEquals(2018 , DayFourteen().improveRecipe2("59414"))
    }

    @Test
    @Ignore
    fun recipesByOutputSlow() {
        kotlin.test.assertEquals(20403320, DayFourteen().improveRecipe2("909441"))
    }

}




