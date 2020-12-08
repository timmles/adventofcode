package year2020.day8

class TerminalByInstruction(instructionSet: List<String>) {

  private val instructions: List<InstructionSet> = instructionSet.map {
    val instruction = when (it.substring(0..2)) {
      "nop" -> Instructions.NOP
      "acc" -> Instructions.ACC
      "jmp" -> Instructions.JMP
      else -> throw Error("Unsupported instruction set")
    }

    InstructionSet(instruction, it.substring(4).toInt())
  }

  fun process(): Result {
    var accumulator = 0

    var pos = 0
    val visited = mutableMapOf<Int, Boolean>()

    while (true) {
      if (pos >= instructions.size) return Result(accumulator, 0)
      if (visited[pos] == true) return Result(accumulator, 1)
      visited[pos] = true
      when (instructions[pos].instruction) {
        Instructions.NOP -> pos++
        Instructions.ACC -> { accumulator += instructions[pos].value; pos++ }
        Instructions.JMP -> pos += instructions[pos].value
      }
    }
  }
}

data class Result(
  var accumulator: Int,
  var errorCode: Int
)

enum class Instructions {
  NOP,
  ACC,
  JMP;
}

data class InstructionSet(
  val instruction: Instructions,
  val value: Int
)

fun searchForFix(input: List<String>): Int {
  TerminalByInstruction(input)

  input.forEachIndexed { index, s ->
    val instructionType = s.substring(0..2)
    if (instructionType == "nop") {
      val modifiedInput = input.toMutableList()
      modifiedInput[index] = modifiedInput[index].replace("nop", "jmp")
      val doWorkWithErrorCode = TerminalByInstruction(modifiedInput).process()
      if (doWorkWithErrorCode.errorCode == 0) return doWorkWithErrorCode.accumulator
    } else if (instructionType == "jmp") {
      val modifiedInput = input.toMutableList()
      modifiedInput[index] = modifiedInput[index].replace("jmp", "nop")
      val doWorkWithErrorCode = TerminalByInstruction(modifiedInput).process()
      if (doWorkWithErrorCode.errorCode == 0) return doWorkWithErrorCode.accumulator
    }
  }
  throw Error("wat")
}

