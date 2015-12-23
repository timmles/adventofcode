package daytwo

class DayTwo {


}

class PresentFactory {
    fun createPresent(specs: String): Present {

        val prezzie = Present(1,2,3)


        println(prezzie.x)

        return Present(1,2,3)
    }

}

class Present(val x: Int, val y: Int, val z: Int) {

}
