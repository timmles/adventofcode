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

    fun orderConcurrent(workers: Int, jobOffset: Int): Int {
        return order().count()
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


