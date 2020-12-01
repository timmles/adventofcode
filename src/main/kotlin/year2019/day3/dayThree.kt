package year2019.day3

import kotlin.math.abs

class Wire(wire: String) {
  internal var corners:MutableList<Pair<Int, Int>> = mutableListOf()

  init {
    var x = 0;
    var y = 0;

    wire.split(',').forEach {
      val direction = it[0]
      val distance = it.substring(1).toInt()

      when (direction) {
        'U' -> repeat(distance, {corners.add(Pair(x,++y))})
        'D' -> repeat(distance, {corners.add(Pair(x,--y))})
        'R' -> repeat(distance, {corners.add(Pair(++x,y))})
        'L' -> repeat(distance, {corners.add(Pair(--x,y))})
        else -> Error("wat")
      }
    }
  }
}

fun intersections(wire1: Wire, wire2: Wire): Set<Pair<Int, Int>> {
  return wire1.corners.intersect(wire2.corners)
}

fun manhathan(wire1: Wire, wire2: Wire): Int? {
  return intersections(wire1, wire2).map { abs(it.first) + abs(it.second) }.min()
}

fun delay(wire1: Wire, wire2: Wire): Int? {
  return intersections(wire1, wire2).map { wire1.corners.indexOf(it) + wire2.corners.indexOf(it) + 2 }.min()
}
