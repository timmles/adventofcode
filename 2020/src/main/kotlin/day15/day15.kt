package year2020.day15

class MemoryGame() {

  fun playNaive(starting: String, offset: Int): Int {
    val memory = starting.split(',').map { it.toInt() }.toMutableList()

    // I don't know why this is 2020-2
    for (i in memory.lastIndex..(offset-2)) {
      val lastIndexOf = memory.subList(0, i).lastIndexOf(memory[i])
      if (lastIndexOf == -1)
        memory.add(0)
      else
        memory.add(i - lastIndexOf)

//      if (i > offset - 20) println("$i | ${memory[i]}")
    }

    return memory.last()
  }

  fun play(starting: String, offset: Int): Int {
    val split = starting.split(',')
    val memory = split.subList(0, split.lastIndex).mapIndexed { index, s -> s.toInt() to index }.toMap().toMutableMap()
    var lastSpoken = split.last().toInt()
    var currentSpoken: Int

    // I don't know why this is 2020-1
    for (i in (memory.size)..(offset-1)) {
      val lastIndexOf = memory[lastSpoken]
      currentSpoken = if (lastIndexOf == null)
        0
      else
        i - lastIndexOf

      memory[lastSpoken] = i
      lastSpoken = currentSpoken

//      if (i > offset - 20) println("$i | ${memory[i]}")
    }

    return memory.maxBy { it.value }!!.key
  }
}

