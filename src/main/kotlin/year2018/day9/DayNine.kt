package year2018.day9

import kotlin.math.max

class DayNine {

    fun play(playerCount: Int, lastMarble: Int): Long {
        var currentMarble = Marble(0)
        var player = 1
        val playerScore = mutableMapOf<Int, Long>()

        printBoard(player, currentMarble)

        for (currentCount in 1..lastMarble) {
            if (currentCount % 23 == 0) {
                val back = currentMarble.back(7)
                currentMarble = back.forward(1)

                val currentScore = playerScore.getOrPut(player, { 0 })
                playerScore.put(player, currentScore + currentCount + back.remove().value)

            } else {
                currentMarble = currentMarble.forward(1).insertAfter(Marble(currentCount))
            }

            printBoard(player, currentMarble)
            player = shift(player, 1, playerCount)
        }

        return playerScore.values.max()!!
    }

    private fun printBoard(player: Int, inputMarble: Marble) {
        if (false) {
            var currentMarble = inputMarble
            print("[$player] ")

            //find 0
            val firstValue = currentMarble.value
            var output = "(${firstValue})"
            currentMarble = currentMarble.forward(1)

            while (currentMarble.value != firstValue) {
                output += " ${currentMarble.value} "
                currentMarble = currentMarble.forward(1)
            }

            val split = max(output.indexOf(" 0 "), output.indexOf("(0)"))

            println(output.substring(split) + output.substring(0, split))
        }
    }

    fun shift(value: Int, shift:Int, cap:Int): Int {
        var newValue = value + shift

        while (newValue < 0 || newValue > cap) {
            if (newValue < 0) {
                newValue = newValue + cap
            } else {
                newValue = newValue - cap
            }
        }

        return newValue
    }
}

class Marble(val value: Int) {
    private var previous = this
    private var next = this

    fun insertAfter(node: Marble): Marble {
        node.previous = this
        node.next = this.next

        this.next.previous = node
        this.next = node

        return node
    }

    fun insertBefore(node: Marble) {
        node.next = this
        node.previous = this.previous

        this.previous.next = node
        this.previous = node
    }

    fun back(steps: Int): Marble {
        if (steps == 0) {
            return this
        } else {
            return previous.back(steps - 1)
        }
    }

    fun forward(steps: Int): Marble {
        if (steps == 0) {
            return this
        } else {
            return next.forward(steps - 1)
        }
    }

    fun remove(): Marble {
        previous.next = next
        next.previous = previous

        next = this
        previous = this

        return this
    }
}
