package year2018.day12

import java.lang.StringBuilder
import kotlin.system.measureTimeMillis

class DayTwelve(var stateInput: String, val instructionSet: List<String>) {

    var state = stateInput.toCharArray()
    var buffer: Int = 0
    val instructions: List<Instruction>

    init {
        instructions = instructionSet.map { Instruction(it.substring(0,5), it.substring(9,10).get(0)) }
    }

    fun runGenerations(numOfGenerations: Long) {
        val knownState = mutableListOf<String>()

//        for (i in 1..numOfGenerations/10000) {
//            val measureTimeMillis = measureTimeMillis {
                for (i2 in 1..numOfGenerations) {
            print("[$i2] ")
            println(state)

                    if (state.take(10).contains('#')) {
                        state = "..........".toCharArray() + state
                        buffer += 10
                    }

                    if (state.takeLast(10).contains('#')) {
                        state = state + "..........".toCharArray()
                    }

//                    if ((i % (10000)) == 0L) println("tick")

                    makeChange()

                    val element = state.fold("",{acc, c -> acc + c })
                    if (knownState.contains(element)) {
//                        println(element)
//                        println(i * i2)
                    } else {
                        knownState.add(element)
                    }
                }
//            }
//            println(measureTimeMillis)
//        }

    }

    private fun makeChange() {
        var newState = "..".toCharArray().toMutableList()

        for (i in 2..state.size - 4) {
            val substring = state.slice(i - 2 .. i + 2).fold("", {acc, c -> acc + c })

            val instruction = instructions.find {it.instruction == substring }

            if (instruction != null) {
                newState.add(instruction.result)
            } else {
                newState.add('.')
            }
        }

        newState.addAll("...".toCharArray().toMutableList())

        state = newState.toCharArray()
    }

    fun toInt(): Int {
        val mapIndexed = state
                .mapIndexed { index, c -> if (c == '#') index - buffer else 0 }
        return mapIndexed
                .sum()
    }

    fun charArrayToString(charArray: CharArray):String {
        return state.fold("",{acc, c -> acc + c })
    }

}

data class Instruction(
        val instruction: String,
        val result: Char
)

//.#....##....#####...#######....#.#..##.
//.#....##....#####...#######....#.#..##..........................