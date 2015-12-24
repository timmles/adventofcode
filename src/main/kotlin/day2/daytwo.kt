package day2

import common.Common

fun main(args: Array<String>) {
    val dayoneInput = Common.getFile("daytwo_input.txt")
    var countWrapping = 0
    var countRibbon = 0

    dayoneInput.forEachLine {
        val prezzie = PresentFactory().createPresent(it)
        countWrapping += prezzie.getSurface() + prezzie.getSlack()
        countRibbon += prezzie.getRibbonBox() + prezzie.getRibbonBow()
    }

    println("wrapping: " + countWrapping)
    println("ribbon: " + countRibbon)
}

class PresentFactory {
    fun createPresent(specs: String): Present {
        val values: List<String> = specs.split('x')

        val prezzie = Present(
                Integer.parseInt(values.get(0)),
                Integer.parseInt(values.get(1)),
                Integer.parseInt(values.get(2)))

        return prezzie
    }
}

data class Present(val x: Int, val y: Int, val z: Int) {
    fun getSurface(): Int {
        return 2*(x*y + y*z + z*x)
    }

    fun getSlack(): Int {
        return Math.min(x*y, Math.min(y*z, z*x))
    }

    fun getRibbonBox(): Int {
        return 2*(x + y + z - listOf(x, y, z).max()!!)
    }

    fun getRibbonBow(): Int {
        return x * y * z
    }
}
