package year2018.day14

class DayFourteen {

    var elfOne = 0
    var elfTwo = 1
    val recipes = mutableListOf(3,7)

    fun improveRecipe(numRecipes: Int): String {
        while (recipes.count() < numRecipes+10) {
            combine()
        }

        return recipes
                .joinToString("")
                .substring(numRecipes, numRecipes + 10)
    }

    fun improveRecipe2(input: String): Int {
        val regex = Regex(input)
        var searchSpace = 10

        while (regex.find(recipes.joinToString("")) == null) {
            for (i in 0..searchSpace) combine()
            searchSpace = searchSpace*searchSpace
        }

        return recipes.joinToString("").indexOf(input)
    }

    fun combine() {
        val new = recipes[elfOne] + recipes[elfTwo]
        recipes.addAll(new.toString().toCharArray().map { it.toString().toInt() })

        elfOne = move(elfOne)
        elfTwo = move(elfTwo)
    }

    private fun move(i: Int): Int {
        return (i + recipes[i] + 1) % recipes.size
    }

    private fun printRecipes() {
        recipes.forEachIndexed { index, i ->
            if(index == elfOne) print("($i)")
            else if (index == elfTwo) print("[$i]")
            else print(" $i ")
        }
        println()
    }
}