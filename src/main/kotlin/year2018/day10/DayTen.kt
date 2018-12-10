package year2018.day9

import kotlin.math.abs

class DayTen(points: List<String>, val textHeight: Int) {

    var lights = mutableListOf<Light>()
    var seconds = 0

    init {
        importLights(points)
        runUntilMessage()
    }

    private fun importLights(points: List<String>) {
        val regex = Regex("position=<(.*),(.*)> velocity=<(.*),(.*)>")

        lights = points.map {
            val groupValues = regex
                    .find(it)!!
                    .groupValues

            Light(
                    Pair(groupValues[1].trim().toInt(), groupValues[2].trim().toInt()),
                    Pair(groupValues[3].trim().toInt(), groupValues[4].trim().toInt()))
        }.toMutableList()
    }

    private fun runUntilMessage() {
        do {
            lights = lights.map {
                Light(it.coord + it.velocity,it.velocity)
            }.toMutableList()

            val minByY = lights.minBy { it.coord.second }!!.coord.second
            val maxByY = lights.maxBy { it.coord.second }!!.coord.second
            seconds++

        } while(abs(minByY-maxByY) > textHeight)
    }

    override fun toString(): String {
        var output = ""
        val coords = lights.map { it.coord }

        val minByX = coords.minBy { it.first }!!.first
        val maxByX = coords.maxBy { it.first }!!.first
        val minByY = coords.minBy { it.second }!!.second
        val maxByY = coords.maxBy { it.second }!!.second

        for (y in minByY..maxByY) {
            for (x in minByX..maxByX) {
                if (coords.contains(Pair(x,y))) {
                    output += "#"
                } else {
                    output += "."
                }
            }
            output += "\n"
        }

        return output
    }

    private operator fun Pair<Int, Int>.plus(plus: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(this.first + plus.first, this.second + plus.second)
    }
}



class Light(var coord: Pair<Int, Int>, var velocity: Pair<Int, Int>) {

}
