package day3

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table

class D3Part1 {
    fun execute(limit: Int): Int {
        val grid = buildGrid(limit)

        val find = grid.cellSet().find { cell -> cell.value == limit }

        return Math.abs(find?.rowKey!!) + Math.abs(find.columnKey!!)
    }

    private fun buildGrid(limit: Int): Table<Int, Int, Int> {
        val table = HashBasedTable.create<Int, Int, Int>()

        var count = 1

        var x = 0
        var y = 0

        var direction = DIRECTION.EAST

        while (count <= limit) {
            // MOVE
            table.put(x, y, count)
            x += direction.x
            y += direction.y
            count++

            // TEST
            val left = direction.left()
            val leftCell = table[x + left.x, y + left.y]

//            println(leftCell)

            if (leftCell == null) {
                direction = direction.left()
            }

        }

        return table
    }
}

class D3Part2 {
    fun execute(limit: Int): Int {
        val grid = buildGrid(limit)

        val find = grid.cellSet().last()

        return find.value!!
    }

    private fun buildGrid(limit: Int): Table<Int, Int, Int> {
        val table = HashBasedTable.create<Int, Int, Int>()

        var count = 1

        var x = 0
        var y = 0

        var direction = DIRECTION.EAST

        while (count <= limit) {
            // MOVE
            val sum = sum(table, x, y)
            table.put(x, y, sum)
            x += direction.x
            y += direction.y
            count = sum

            // TEST
            val left = direction.left()
            val leftCell = table[x + left.x, y + left.y]

//            println(leftCell)

            if (leftCell == null) {
                direction = direction.left()
            }

        }

        return table
    }

    private fun sum(table: HashBasedTable<Int, Int, Int>, x: Int, y: Int): Int {
        var n = table[DIRECTION.NORTH.x(x), DIRECTION.NORTH.y(y)]
        var ne = table[DIRECTION.NORTH_EAST.x(x), DIRECTION.NORTH_EAST.y(y)]
        var e = table[DIRECTION.EAST.x(x), DIRECTION.EAST.y(y)]
        var se = table[DIRECTION.SOUTH_EAST.x(x), DIRECTION.SOUTH_EAST.y(y)]
        var s = table[DIRECTION.SOUTH.x(x), DIRECTION.SOUTH.y(y)]
        var sw = table[DIRECTION.SOUTH_WEST.x(x), DIRECTION.SOUTH_WEST.y(y)]
        var w = table[DIRECTION.WEST.x(x), DIRECTION.WEST.y(y)]
        var nw = table[DIRECTION.NORTH_WEST.x(x), DIRECTION.NORTH_WEST.y(y)]

        if(n == null) n = 0
        if(ne == null) ne = 0
        if(e == null) e = 0
        if(se == null) se = 0
        if(s == null) s = 0
        if(sw == null) sw = 0
        if(w == null) w = 0
        if(nw == null) nw = 0

        val i = n + ne + e + se + s + sw + w + nw

        return if (i == 0) 1 else i
    }
}


enum class DIRECTION(val x: Int, val y: Int) {
    NORTH(1, 0),
    NORTH_EAST(1, 1),
    EAST(0, 1),
    SOUTH_EAST(-1, 1),
    SOUTH(-1, 0),
    SOUTH_WEST(-1, -1),
    WEST(0, -1),
    NORTH_WEST(1, -1);

    fun left(): DIRECTION {
        return when (this) {
            DIRECTION.NORTH -> {
                DIRECTION.WEST
            }
            DIRECTION.EAST -> {
                DIRECTION.NORTH
            }
            DIRECTION.SOUTH -> {
                DIRECTION.EAST
            }
            DIRECTION.WEST -> {
                DIRECTION.SOUTH
            }
            else -> {
                throw Exception()
            }
        }
    }

    fun x(x: Int): Int {
        return x + this.x
    }

    fun y(y: Int): Int {
        return y + this.y
    }


}