package year2018.day2

import java.lang.Error

class DayTwoP1 {

    fun checksum(boxIds: List<String>): Int {

        val destructBoxIds = boxIds.map { destructToInt(it) }

        val twos = destructBoxIds.count { it.contains(2) }
        val threes = destructBoxIds.count { it.contains(3) }

        return twos * threes
    }


    private fun destructToInt(boxId: String): List<Int> {
        val distinct = boxId.toCharArray().distinct()

        return distinct.map { distinctChar ->
            boxId.count { innerLoopChar -> innerLoopChar == distinctChar }
        }
    }

}

class DayTwoP2 {
    fun find(listOf: List<String>): String {
        listOf.forEach {search ->
            for (i in 0..(search.count()-1)) {
                val regexSearch = search.replaceRange(i, i+1, ".")
                val regex = Regex(regexSearch)

                val searchSpace = listOf.toMutableList()
                searchSpace.remove(search)
                searchSpace.forEach {
                    val find = regex.find(it)
                    if (find != null) return regexSearch.replace(".", "")
                }
            }
        }

        throw Error("Failed to find a match")
    }
}