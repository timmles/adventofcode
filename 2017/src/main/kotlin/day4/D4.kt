package day4

class D4Part1 {
    companion object {
        fun validate(passphrase: String): Boolean {
            val words = passphrase.split(' ')

            return words.size == words.distinct().size
        }
    }
}

class D4Part2 {
    companion object {
        fun validate(passphrase: String): Boolean {
            var words = passphrase.split(' ')
            words = words.map { input -> input.split("").sorted().reduce({reduced, input -> reduced + input }) }

            return words.size == words.distinct().size
        }
    }
}