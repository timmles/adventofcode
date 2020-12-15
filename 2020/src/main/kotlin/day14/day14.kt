package year2020.day14

object PartOne {
  /**
   * to create a bitmask:
   * - first erase the bits you want to mask using an `and`.
   * - then mask the bit by using an `or`
   * https://stackoverflow.com/questions/3415298/best-way-to-overwrite-some-bits-in-a-particular-range
   *
   * XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
   * 111111111111111111111111111110111101
   * 000000000000000000000000000001000000
   */
  internal fun mask(value: Long, mask: String): Long {
    val eraseMask = java.lang.Long.parseLong(mask.replace('1', '0').replace('X', '1'), 2)
    val bitMask = java.lang.Long.parseLong(mask.replace('X', '0'), 2)

    return (value and eraseMask) or bitMask
  }

  fun doWork(input: List<String>): Long {
    val memory = LongArray(100_000)
    var currentMask = ""
    input.forEach {
      val matchEntire = Regex("^mask = (\\w*)").matchEntire(it)
      if (matchEntire != null) {
        currentMask = matchEntire.groupValues[1]
      } else {
        val (whole, memPos, value) = Regex("^mem\\[(\\d*)\\] = (\\w*)").matchEntire(it)!!.groupValues
        memory[memPos.toInt()] = mask(value.toLong(), currentMask)
      }
    }

    return memory.sum()
  }
}
