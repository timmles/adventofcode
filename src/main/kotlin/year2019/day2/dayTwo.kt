package year2019.day2

enum class Intcode {
  ADD,
  MULTIPLY,
  HALT;

  companion object {
    fun findByCode(code: Int): Intcode {
      return when (code) {
        1 -> ADD
        2 -> MULTIPLY
        99 -> HALT
        else -> throw Exception("Doesn't exits")
      }
    }
  }
}

fun calculate(codeInput: String): String {
  val codes = codeInput.split(",").map { it.toInt() }.toMutableList()
  var index = 0

  loop@ while (true) {
    when (codes[index]) {
      1 -> {
        codes[codes[index+3]] = codes[codes[index+1]] + codes[codes[index+2]];
        index += 4
      }
      2 -> {
        codes[codes[index+3]] = codes[codes[index+1]] * codes[codes[index+2]];
        index += 4
      }
      99 -> break@loop
      else -> break@loop
    }
  }

  return codes.joinToString(",")
}
