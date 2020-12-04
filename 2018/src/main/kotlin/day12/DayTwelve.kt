package year2018.day12

class DayTwelve(stateInput: String, instructionSet: List<String>) {

    var state = stateInput.toCharArray()
    var buffer: Int = 0
    val instructions: List<Instruction>

    init {
        instructions = instructionSet.map { Instruction(it.substring(0, 5), it.substring(9, 10).get(0)) }
    }

    fun runGenerations(numOfGenerations: Long): Long {
        val knownState = mutableListOf<String>()

        for (i in 1..numOfGenerations) {
            ensureBuffer()
            makeChange()

            knownState.add(state.fold("", { acc, c -> acc + c }))

            val map = knownState.map { it.trim('.') }
            if (map.distinct().size != knownState.size) {
                return toInt(numOfGenerations - i)
            }
        }

        return toInt()
    }

    private fun ensureBuffer() {
        if (state.take(10).contains('#')) {
            state = "..........".toCharArray() + state
            buffer += 10
        }

        if (state.takeLast(10).contains('#')) {
            state = state + "..........".toCharArray()
        }
    }

    private fun makeChange() {
        val newState = "..".toCharArray().toMutableList()

        for (i in 2..state.size - 4) {
            val substring = state.slice(i - 2..i + 2).fold("", { acc, c -> acc + c })

            val instruction = instructions.find { it.instruction == substring }

            if (instruction != null) {
                newState.add(instruction.result)
            } else {
                newState.add('.')
            }
        }

        newState.addAll("...".toCharArray().toMutableList())

        state = newState.toCharArray()
    }

    private fun toInt(shift: Long = 0): Long {
        return state
                .mapIndexed { index, c -> if (c == '#') index - buffer + shift else 0 }
                .sum()
    }
}

data class Instruction(
        val instruction: String,
        val result: Char
)
