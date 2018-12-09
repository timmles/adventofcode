package year2018.day9

class DayNine {

    val marbles = mutableListOf<Int>(0)
    var currentMarbleIndex = 0
    var currentCount = 1
    var player = 1
    val playerScore = mutableMapOf<Int, Long>()

    fun play(playerCount: Int, lastMarble: Int): Long {
        printBoard()

        for (i in 0.until(lastMarble)) {
            if (currentCount % 23 == 0) {

                currentMarbleIndex = shift(currentMarbleIndex, -7, marbles.size)

                val currentScore = playerScore.getOrPut(player, { 0 })
                playerScore.put(player, currentScore + currentCount + marbles.removeAt(currentMarbleIndex))

            } else {
                currentMarbleIndex = shift(currentMarbleIndex, 2, marbles.size)
                marbles.add(currentMarbleIndex, currentCount)
            }

            printBoard()
            currentCount++
            player = shift(player, 1, playerCount)
        }

        return playerScore.maxBy { it.value }!!.value
    }

    private fun printBoard() {
        if (false) {
            print("[$player] ")

            marbles.forEachIndexed { index, it ->
                if (index == currentMarbleIndex)
                    print("($it)")
                else {
                    print(" $it ")
                }
            }

            println()
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