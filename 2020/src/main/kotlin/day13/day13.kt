package year2020.day13

class Placeholder() {

  fun part1(input: List<String>): Int {
    val departEstimate = input[0].toInt()
    val map = input[1].split(',').filter { it != "x" }.map { it.toInt() }
      .map { it to (it - (departEstimate % it)) }
    val minBy = map.minBy { it.second }!!
    return minBy.first * minBy.second
  }

  fun part2_bf_intersect(input: List<String>): Long {
    var startOffset = 0L
    val batchSize = 1_000_000L
    var countOffset = 0L

    while (true) {
      val busses = arrayListOf<List<Long>>()
      input[1].split(',').forEach {
        if (it == "x") countOffset++
        else {
          val current = it.toLong()
          val specificOffset = (startOffset / current) * current
          busses.add(((specificOffset - countOffset)..(batchSize + startOffset) step current).toList())
          countOffset++
        }
      }
      countOffset = 0L
      startOffset += batchSize

      val reduce = busses.map { it.toSet() }.reduce { acc, set -> acc.intersect(set) }
      if (reduce.isNotEmpty()) return reduce.first()
    }
  }

  fun part2_bf_modulus(input: List<String>, offset: Long): Long {
    val input = input[1]
      .split(',')
      .mapIndexed { index, it ->
        if (it == "x") null
        else Pair(it.toLong(), index)
      }.filterNotNull()

    val largest = input.maxBy { it.first }!!

    var departTime: Long = (offset/largest.first)*largest.first + (largest.first - largest.second.toLong())
    outer@ while (true) {
      for (el in input) {
        if ((departTime + el.second) % el.first != 0L) {
          departTime += largest.first
          continue@outer
        }
      }
      break
    }
    return departTime
  }
}

