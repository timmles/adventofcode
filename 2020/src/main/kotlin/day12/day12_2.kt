package year2020.day12

import kotlin.math.abs

class Ship2(val input: List<String>) {
  var x = 0
  var y = 0
  var waypointX = 10
  var waypointY = 1

  fun followInstructions(): Int {
    input.forEach {
      var direction = it.substring(0, 1)
      val value = it.substring(1).toInt()

      when (direction) {
        "N", "S", "E", "W" -> { move(direction, value) }
        "F" -> { x += waypointX * value; y += waypointY * value }
        "L", "R" -> { rotate(direction, value) }
      }

      println("$it")
      println("waypointx: $waypointX, waypointy: $waypointY")
      println("x: $x, y: $y")
      println()
    }

    return Math.abs(x) + Math.abs(y)
  }

  private fun move(direction: String, value: Int) {
    when (direction) {
      "N" -> { waypointY += value }
      "S" -> { waypointY -= value }
      "E" -> { waypointX += value }
      "W" -> { waypointX -= value }
    }
  }

  internal fun rotate(rotate: String, value: Int) {
    repeat(value / 90) {
      if (waypointX >= 0 && waypointY >= 0) {
        waypointX *= -1;
      } else if (waypointX >= 0 && waypointY < 0) {
        waypointX *= -1;
      } else if (waypointX < 0 && waypointY < 0) {
        waypointX *= -1;
      } else if (waypointX < 0 && waypointY >= 0) {
        waypointX *= -1;
      } else {
        println("miss")
      }
      val tmpwaypointX = waypointX
      waypointX = waypointY
      waypointY = tmpwaypointX

      if (rotate == "L") { waypointX *= -1; waypointY *= -1;}

//      println("x: $waypointX y: $waypointY")
    }

//
//    10 units east and 4 units north
//    x = 10
//    y = 4
//    4 units east and 10 units south of the ship
//    x = 4
//    y = -10
//    10 units west and 4 units south
//    x = -10
//    y = -4
//    4 units west and 10 units north of the ship
//    x = -4
//    y = 10

  }
}

