package year2018.day5

class DaySeven(instructionsInput: List<String>) {
    val instructions:MutableList<Instruction>

    init {
        val stepRegex = Regex("Step (.) .* step (.)")
        instructions = mutableListOf()

        instructionsInput.forEach {
            val input = stepRegex.find(it)!!.groupValues

            val id = input[2]
            val prereq = input[1]

            var find = instructions.find { it.id == id }

            if (find == null) {
                find = Instruction(id)
                find.prereq.add(prereq)
                instructions.add(find)
            } else {
                find.prereq.add(prereq)
            }
        }

        instructions.flatMap { it.prereq }.distinct().minus(instructions.map { it.id }).forEach { instructions.add(Instruction(it)) }
    }

    fun order(): String {
        return pickupNext(instructions.toMutableList(), "")
    }

    fun order(workersCount: Int, jobOffset: Int): Int {
        var timer = -1
        var completed = ""
        var workers: List<Pair<String, Int>?> = List(workersCount) { null }

        do {
            timer++

            workers = workers.map {
                var current = it

                if (current != null) {
                    current = current.copy(current.first, current.second - 1)

                    if (current.second == 0) {
                        completed += current.first
                        current = null
                    }
                }

                if (current == null) {
                    val nextInstructions = instructions.filter {
                        it.prereq.isEmpty() || stringContainsAll(completed, it.prereq)
                    }.sortedBy { it.id }

                    if (nextInstructions.isNotEmpty()) {
                        val scheduleInstruction = nextInstructions.first()
                        instructions.remove(scheduleInstruction)
                        current = Pair(scheduleInstruction.id, jobOffset + (scheduleInstruction.id.first().toInt() - 'A'.toInt() + 1))
                    }
                }

                current
            }

        } while (workers.filter { it != null }.isNotEmpty())


        return timer
    }

    private fun pickupNext(instructions: MutableList<Instruction>, list:String): String {
        if (instructions.isEmpty()) return list

        val current = instructions.filter {
            it.prereq.isEmpty() || stringContainsAll(list, it.prereq)
        }.sortedBy { it.id }.first()

        instructions.remove(current)
        return pickupNext(instructions, list + current.id)
    }

    private fun stringContainsAll(list: String, prereq: MutableList<String>): Boolean {
        return prereq.filterNot { list.contains(it) }.isEmpty()
    }
}

class Instruction(
        val id: String
) {
    val prereq: MutableList<String> = mutableListOf()
}


