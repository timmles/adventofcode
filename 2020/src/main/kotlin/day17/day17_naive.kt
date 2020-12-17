package year2020.day17

class PowerCubeNaive(val input: List<String>) {
  var space2 = Array(100) { Array(100) { BooleanArray(100) { false } } }

  init {
    input.forEachIndexed { row, it ->
      it.forEachIndexed { col, it: Char ->
        if (it == '#') space2[row+50][col+50][50] = true
      }
    }
  }


  fun doWork(): Int {
    life()
    life()
    life()
    life()
    life()
    life()

    return space2.sumBy { it.sumBy { it.count { it } } }
  }

  fun life() {
    val range = 50..55
    val lastgen = space2
    val currentGen = Array(100) { Array(100) { BooleanArray(100) { false } } }
    (1 until 99).forEach { row ->
      (1 until 99).forEach { col ->
        (1 until 99).forEach { z ->
          val neighbors = neighbors(lastgen, row, col, z)
          val activeNeighbors = neighbors.count { it }

          when (lastgen[row][col][z]) {
            true -> currentGen[row][col][z] = activeNeighbors == 2 || activeNeighbors == 3
            false -> currentGen[row][col][z] = activeNeighbors == 3
          }
        }
        if (range.contains(row) && range.contains(col)) println()
      }
      if (range.contains(row)) println()
    }

    space2 = currentGen
  }

  private fun neighbors(lastgen: Array<Array<BooleanArray>>, rowIn: Int, colIn: Int, zIn: Int): List<Boolean> {
    val neighbors = mutableListOf<Boolean>()

    (rowIn - 1..rowIn + 1).forEach { row ->
      (colIn - 1..colIn + 1).forEach { col ->
        (zIn - 1..zIn + 1).forEach { z ->
          if ((row == rowIn && col == colIn && z == zIn).not()) neighbors.add(lastgen[row][col][z])
        }
      }
    }

    return neighbors
  }

  fun printSpace(zIndex: Int, width: Int) {
    println("z=$zIndex")
    (50 until 50+width).forEach { row ->
      (50 until 50+width).forEach { col ->
        when (space2[row][col][zIndex+50]) {
          true -> print('#')
          false -> print('.')
        }
      }
      println()
    }
  }
}

