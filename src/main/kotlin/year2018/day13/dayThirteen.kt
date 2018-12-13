package year2018.day13

import com.google.common.collect.HashBasedTable

class DayThirteen(trackInput: List<String>) {

    val track = HashBasedTable.create<Int, Int, Char>()
    var carts = mutableListOf<Cart>()

    val status = Status()

    init {
        trackInput.forEachIndexed { y, s ->
            s.forEachIndexed { x, c ->
                var newChar = when (c) {
                    '^' -> {
                        carts.add(Cart(x, y, Direction.create(c))); '|'
                    }
                    '>' -> {
                        carts.add(Cart(x, y, Direction.create(c))); '-'
                    }
                    'v' -> {
                        carts.add(Cart(x, y, Direction.create(c))); '|'
                    }
                    '<' -> {
                        carts.add(Cart(x, y, Direction.create(c))); '-'
                    }
                    else -> c
                }

                track.put(x, y, newChar)
            }
        }
    }

    fun simulate(): Status {
       while (carts.count { it.alive } > 1) {
           move()
           status.count++
        }

        val find = carts.find { it.alive }

        if (find != null) {
            val (x, y) = find
            status.lastManStanding = Pair(x,y)
        }

        return status
    }

    fun testRougeCart() {
        carts.forEach {
            val c = track[it.x, it.y]
            if(c == ' ') throw Error("derail")
        }
    }

    private fun findCollision(currentCart: Cart): List<Cart> {
        val filter = carts.filter { it.alive }.filter { currentCart.sameLocation(it) }

        if (filter.size > 1)
            return filter
        else return emptyList()
    }

    fun move() {
        carts.sortedWith(compareBy({ it.x }, { it.y }))
                .forEach {
                    if (it.alive) {
                        when (it.direction) {
                            Direction.UP -> it.y--
                            Direction.RIGHT -> it.x++
                            Direction.DOWN -> it.y++
                            Direction.LEFT -> it.x--
                        }

                        val track = track[it.x, it.y]

                        if (track == '|' || track == '-') {
                            //do nothing
                        } else if (track == '\\') {
                            it.direction = when (it.direction) {
                                Direction.UP, Direction.DOWN -> it.direction.turnLeft()
                                Direction.RIGHT, Direction.LEFT -> it.direction.turnRight()
                            }
                        } else if (track == '/') {
                            it.direction = when (it.direction) {
                                Direction.UP, Direction.DOWN -> it.direction.turnRight()
                                Direction.RIGHT, Direction.LEFT -> it.direction.turnLeft()
                            }
                        } else if (track == '+') {
                            it.intersection()
                        }

                        val listCollision = findCollision(it)
                        if (listCollision.isNotEmpty()) {
                            if (status.firstCollision == null) {
                                val collision = listCollision[0]
                                status.firstCollision = Pair(collision.x, collision.y)
                            }

                            listCollision.forEach { it.alive = false }
                        }
                    }
                }
    }

    fun printTrack() {
        track.rowKeySet().forEachIndexed { x, i ->
            track.column(i).forEach { y ->
                if (y.key != null) {
                    val cart = carts.find { it.y == x && it.x == y.key }
                    if (cart != null)
                        print(cart.direction)
                    else
                        print(y.value)
                }
            }
            println()
        }
    }
}

data class Cart(
        var x: Int,
        var y: Int,
        var direction: Direction,
        var alive: Boolean = true
) {
    var intersections = 0;

    fun intersection() {
        direction = when (intersections % 3) {
            0 -> {intersections = 1; direction.turnLeft()}
            1 -> {intersections = 2; direction}
            2 -> {intersections = 3; direction.turnRight()}
            else -> throw Error("wat")
        }
    }

    fun sameLocation(it: Cart): Boolean {
        return this.x == it.x && this.y == it.y
    }
}

enum class Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    fun turnRight(): Direction {
        return when (this) {
            UP -> RIGHT
            RIGHT -> DOWN
            DOWN -> LEFT
            LEFT -> UP
        }
    }

    fun turnLeft(): Direction {
        return when (this) {
            UP -> LEFT
            RIGHT -> UP
            DOWN -> RIGHT
            LEFT -> DOWN
        }
    }

    companion object {
        fun create(char: Char): Direction {
            return when (char) {
                '^' -> UP
                '>' -> RIGHT
                'v' -> DOWN
                '<' -> LEFT
                else -> throw Error("no direction")
            }
        }
    }

    override fun toString(): String {
        return when (this) {
            UP -> "^"
            RIGHT -> ">"
            DOWN -> "v"
            LEFT -> "<"
        }
    }
}

data class Status(
        var firstCollision: Pair<Int, Int>? = null,
        var lastManStanding: Pair<Int, Int>? = null,
        var count: Int = 0
)