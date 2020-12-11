package year2020.day11

class GameOfLife2(input: List<String>) {
  val gridSizeRow = input.size
  val gridSizeColumn = input[0].length
  val initial: Array<Array<Char>> = createArray()

  private fun createArray(): Array<Array<Char>> {
    var cinema = arrayOf<Array<Char>>()

    for (i in 0 until gridSizeRow) {
      var array = arrayOf<Char>()
      for (j in 0 until gridSizeColumn) {
        array += ' '
      }
      cinema += array
    }

    return cinema
  }

  init {
    input.forEachIndexed { row, s ->
      s.forEachIndexed { column, c ->
        initial[row][column] = c
      }
    }
  }


  fun doWork(): Int {
    return generation(0, initial).flatten().count { it == '#' }
  }

  internal fun generation(generation: Int, last: Array<Array<Char>>): Array<Array<Char>> {
//    printGrid(last)

    val current: Array<Array<Char>> = createArray()

    for (row in last.indices) {
      for (column in last[row].indices) {
        if (last[row][column] == '.') {
          current[row][column] = '.'
        }
        else {
          val adjacentSeats = arrayOf(
            get(last, row, column, -1, -1),
            get(last, row, column, -1,  0    ),
            get(last, row, column, -1,  1),
            get(last, row, column,  0, -1),
            get(last, row, column,  0,  1),
            get(last, row, column,  1, -1),
            get(last, row, column,  1,  0    ),
            get(last, row, column,  1,  1),
          ).filterNotNull().filter { it != '.' }

          if (adjacentSeats.count { it == 'L' } == adjacentSeats.size) current[row][column] = '#'
          else if (adjacentSeats.count { it == '#' } >= 5) current[row][column] = 'L'
          else current[row][column] = last[row][column]
        }
      }
    }

    if (current.contentDeepEquals(last)) {
      return current
    } else {
      return generation(generation+1, current)
    }
  }

  private fun printGrid(last: Array<Array<Char>>) {
    for (element in last) {
      for (element in element)
        print(element)
      println()
    }
    println()
  }

  private fun get(last: Array<Array<Char>>, row: Int, column: Int, rowOffSet: Int, colOffset: Int): Char? {
    val rowPossible = row + rowOffSet
    val colPossible = column + colOffset
    if (rowPossible < 0 || colPossible < 0 || rowPossible > last.lastIndex || colPossible > last[row].lastIndex) return null
    else if (last[rowPossible][colPossible] == '.') return get(last, row+rowOffSet, column+colOffset, rowOffSet, colOffset)
    else return last[rowPossible][colPossible]
  }
}

