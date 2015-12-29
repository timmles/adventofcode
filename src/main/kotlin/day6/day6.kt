package day6

import common.Common
import java.util.*

fun main(args: Array<String>) {
    val daysixInput = Common.getFile("day6_input.txt")
    val grid = LightGrid()

    daysixInput.forEachLine {
        val instruction = grid.parseInstruction(it)
        grid.configureLights(instruction)
    }

    println(grid.countLights())
}

class LightGrid {
    var lightGrid = HashMap<Pair<Int, Int>, Int>()

    init {
        for (x in 0..999) {
            for (y in 0..999) {
                lightGrid[Pair(x, y)] = 0
            }
        }
    }

    fun parseInstruction(input: String): Instruction {
        val actionPattern = "(turn on)|(turn off)|(toggle)"
        val locationPattern = "([0-9]+,[0-9]+)"

        val actionMatcher = Regex(actionPattern).find(input)
        val action: LightAction = when(actionMatcher!!.value) {
            "turn on" -> LightAction.TURN_ON
            "turn off" -> LightAction.TURN_OFF
            "toggle" -> LightAction.TOGGLE
            else -> throw Exception()
        }

        val locationMatch = Regex(locationPattern).find(input)
        val start = locationMatch!!.value
        val startSplit = start.split(',')
        val startPair = Pair(startSplit.get(0).toInt(), startSplit.get(1).toInt())

        val end = locationMatch.next()!!.value
        val endSplit = end.split(',')
        val endPair = Pair(endSplit.get(0).toInt(), endSplit.get(1).toInt())

        return Instruction(action, startPair, endPair)
    }

    fun configureLights(instruct: Instruction) {
        for (x in instruct.start.first..instruct.end.first) {
            for (y in instruct.start.second..instruct.end.second) {
                lightGrid[Pair(x,y)] = when(instruct.action) {
                    LightAction.TURN_OFF -> lightGrid[Pair(x,y)]!!.minus(1)
                    LightAction.TURN_ON -> lightGrid[Pair(x,y)]!!.plus(1)
                    LightAction.TOGGLE -> lightGrid[Pair(x,y)]!!.plus(2)
                }

                if (lightGrid[Pair(x,y)]!! < 0) {
                    lightGrid[Pair(x,y)] = 0
                }
            }
        }
    }

    fun countLights(): Int {
        var count: Int = 0

        for (x in 0..999) {
            for (y in 0..999) {
                count += lightGrid[Pair(x, y)]!!
            }
        }

        return count
    }
}

data class Instruction(val action:LightAction, val start:Pair<Int, Int>, val end:Pair<Int, Int>) {

}

enum class LightAction {
    TURN_ON,
    TURN_OFF,
    TOGGLE
}

enum class LightState {
    LIGHT_ON {
        override fun toggle(): LightState {
            return LIGHT_OFF
        }
    },
    LIGHT_OFF {
        override fun toggle(): LightState {
            return LIGHT_ON
        }
    };

    abstract fun toggle(): LightState
}