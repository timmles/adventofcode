package year2020.day3

class AdventMap(val map: List<String>) {

  fun traverseSearch(angles: List<Pair<Int, Int>>): Long {
    return angles.fold(1L) {acc, pair -> acc * traverse(pair) }
  }

  fun traverse(offset: Pair<Int, Int>): Int {
    var x = 0
    var y = 0
    var tree = 0

    while (y < mapHeight()) {
      val get = get(x, y)
      if (get == '#') tree++
      x += offset.first
      y += offset.second
    }
    return tree
  }

  private fun get(x: Int, y: Int): Char {
    return map[y][x%map[y].length]
  }

  private fun mapHeight(): Int {
    return map.size
  }
}
