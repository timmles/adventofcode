package year2020.day15

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day15KtTest {

  @Test
  fun example1() {
    assertEquals(436,   MemoryGame().play("0,3,6", 2020))
    assertEquals(1,     MemoryGame().play("1,3,2", 2020))
    assertEquals(10,    MemoryGame().play("2,1,3", 2020))
    assertEquals(27,    MemoryGame().play("1,2,3", 2020))
    assertEquals(78,    MemoryGame().play("2,3,1", 2020))
    assertEquals(438,   MemoryGame().play("3,2,1", 2020))
    assertEquals(1836,  MemoryGame().play("3,1,2", 2020))
  }

  @Test
  fun question1() {
    val input = Common.getFile("day15.txt").readLines()[0]
    assertEquals(1, MemoryGame().play(input, 2020))
  }

  @Test
  fun example2() {
    assertEquals(175594,   MemoryGame().play("0,3,6", 30000000))
//    assertEquals(2578,     MemoryGame().play("1,3,2", 30000000))
//    assertEquals(3544142,    MemoryGame().play("2,1,3", 30000000))
//    assertEquals(261214,    MemoryGame().play("1,2,3", 30000000))
//    assertEquals(6895259,    MemoryGame().play("2,3,1", 30000000))
//    assertEquals(18,   MemoryGame().play("3,2,1", 30000000))
//    assertEquals(362,  MemoryGame().play("3,1,2", 30000000))
  }

  @Test
  fun question2() {
    val input = Common.getFile("day15.txt").readLines()[0]
    assertEquals(110871, MemoryGame().play(input, 30000000))
  }
}

