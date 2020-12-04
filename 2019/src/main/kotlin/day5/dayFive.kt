package year2019.day5

class IntCode(codeInput: String, val input: Int) {

  constructor(codeInput: String) : this(codeInput, 0)

  var output: Int? = null
  private var codes: MutableList<Int>

  init {
    this.codes = codeInput.split(",").map { it.toInt() }.toMutableList()
    calculate()
  }

  private fun calculate() {
    var index = 0

    loop@ while (true) {
      val instruction = codes[index]
      val readMode1 = extract(instruction, 100) == 0
      val readMode2 = extract( instruction, 1000) == 0
      val readMode3 = extract(instruction, 10000) == 0

      when (instruction % 100) {
        1 -> {
          codes[codes[index + 3]] = read(codes[index + 1], readMode1) + read(codes[index + 2], readMode2);
          index += 4

        }
        2 -> {
          codes[codes[index + 3]] = read(codes[index + 1], readMode1) * read(codes[index + 2], readMode2);
          index += 4
        }
        3 -> {
          codes[codes[index + 1]] = input
          index += 2
        }
        4 -> {
          output = read(codes[index + 1], readMode1)
          index += 2
        }
        5 -> {
          if (read(codes[index + 1], readMode1) != 0) {
            index = read(codes[index + 2], readMode2);
          } else {
            index += 3
          }
        }
        6 -> {
          if (read(codes[index + 1], readMode1) == 0) {
            index = read(codes[index + 2], readMode2);
          } else {
            index += 3
          }
        }
        7 -> {
          codes[codes[index + 3]] = (read(codes[index + 1], readMode1) < read(codes[index + 2], readMode2)).toInt();
          index += 4
        }
        8 -> {
          codes[codes[index + 3]] = (read(codes[index + 1], readMode1) == read(codes[index + 2], readMode2)).toInt();
          index += 4
        }
        99 -> break@loop
        else -> throw Error("Unkown code")
      }
    }
  }

  private fun extract(value: Int, base: Int): Int {
    return value / base % 10
  }

  fun read(read: Int, position: Boolean): Int {
    if (position) return codes[read]
    else return read
  }

  fun status(): String {
    return codes.joinToString(",")
  }
}


fun Boolean.toInt() = if (this) 1 else 0
