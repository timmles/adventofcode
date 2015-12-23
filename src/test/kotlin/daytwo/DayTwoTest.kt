package daytwo

import org.junit.Assert.*
import org.junit.Test

class DayTwoTest {

    @Test
    fun testFactory() {
        val presentFactory = PresentFactory();

        val present: Present = presentFactory.createPresent("")


    }
}


