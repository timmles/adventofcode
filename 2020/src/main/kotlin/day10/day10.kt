package year2020.day10

class Placeholder(input: List<Int>) {
  val adapters: List<Int>


  init {
    val tmpInput = input.toMutableList()
    tmpInput.add(0)
    tmpInput.add(tmpInput.max()!! + 3)
    tmpInput.sort()

    adapters = tmpInput.toList()
  }

  fun usingAllAdaptors(): Int {
    var first = 0
    var second = 0
    var third = 0

    for (i in 1 until adapters.size) {
      when (adapters[i] - adapters[i - 1]) {
        1 -> first++
        2 -> second++
        3 -> third++
      }
    }

    return first * third
  }

  fun possibleAdaptors(): Long {
    val memTable = LongArray(adapters.size)
    memTable[adapters.lastIndex] = 1

    for (index in adapters.lastIndex-1 downTo 0) {
      val maxSize = Math.min(index + 4, adapters.lastIndex)
      memTable[index] = (index + 1..maxSize)
        .filter { adapters[it] <= adapters[index] + 3 }
        .map { memTable[it] }.sum()
    }

    return memTable[0]
  }
}

