package year2018.day3

import com.google.common.collect.HashBasedTable

class DayThree {

    fun convertImportToClaims(claimsInput: List<String>): List<Claim> {
        val regex = Regex("#(\\d*) @ (\\d*),(\\d*): (\\d*)x(\\d*)")
        val claims: List<Claim> = claimsInput.map {
            val matchEntire = regex.matchEntire(it)

            if (matchEntire != null) {
                val groupValues = matchEntire.groupValues
                Claim(
                        groupValues[1].toInt(),
                        groupValues[2].toInt(),
                        groupValues[3].toInt(),
                        groupValues[4].toInt(),
                        groupValues[5].toInt()
                )
            } else {
                throw Error("Import error :: $it")
            }
        }

        return claims
    }

    fun countOverlap(claims: List<Claim>): Int {
        val table = createTable(claims)
        return table!!.values().filter { it.size > 1 }.count()
    }

    fun findNoOverlap(claims: List<Claim>): Int {
        val table = createTable(claims)
        val values = table!!.values()

        claims.forEach {claim ->
            val count = values.filter { it.contains(claim.id) }.filter { it.size > 1 }.count()

            if (count == 0) return claim.id
        }

        throw Error("Found no single elements")
    }

    private fun createTable(claims: List<Claim>): HashBasedTable<Int, Int, MutableList<Int>>? {
        val maxX = claims.maxBy { it.x2 }!!.x2
        val maxY = claims.maxBy { it.y2 }!!.y2

        val table = HashBasedTable.create<Int, Int, MutableList<Int>>()

        claims.forEach {
            for (x in it.x1.until(it.x2)) {
                for (y in it.y1.until(it.y2)) {
                    if (table[x, y] == null) table.put(x, y, mutableListOf<Int>())
                    table[x, y].add(it.id)
                }
            }
        }

        return table
    }
}

class Claim(
        val id: Int,
        val x1: Int,
        val y1: Int,
        val width: Int,
        val height: Int
) {
    val x2 = x1 + width
    val y2 = y1 + height
}