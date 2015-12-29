package day7

import java.util.*

fun main(args: Array<String>) {

}

class Circuit {
    val known = HashMap<String, Int>()
    val breadBoard = ArrayList<Node>()

    fun addNode(input: String): Unit {
        val split = input.split("->").map { it.trim() }

        if (split.size == 2) {
            val source = split[0]
            val output = split[1]
            when {
                source.contains("AND") -> breadBoard.add(AndNode(source, output))
                source.contains("OR") -> breadBoard.add(OrNode(source, output))
                source.contains("LSHIFT") -> breadBoard.add(LeftShiftNode(source, output))
                source.contains("RSHIFT") -> breadBoard.add(RightShiftNode(source, output))
                source.contains("NOT") -> breadBoard.add(NotNode(source, output))
                else -> known[output] = source.toInt()
            }
        } else {
            throw Exception("to many args")
        }
    }

    fun runCircuit() {
        while(stillUnknowns()) {
            for (n in breadBoard) {
                if (known[n.output] == null) {
                    val process = n.process(known)
                    if (process != null) {
                        known[n.output] = process
                    }
                }
            }
        }
    }

    private fun stillUnknowns(): Boolean {
        for (n in breadBoard) {
            if(known[n.output] == null) return true
        }

        return false
    }
}

abstract class Node {
    abstract var output: String
    abstract fun process(known: HashMap<String, Int>): Int?
}

class NotNode(input: String, override var output: String) : Node() {
    var source: String

    init  {
        source = input.removePrefix("NOT").trim()
    }

    override fun process(known: HashMap<String, Int>):Int? {
        val knownSource = known[source]

        if (knownSource != null) {
            return knownSource.inv() + (Short.MAX_VALUE + 1) * 2
        } else {
            return null
        }
    }
}

abstract class DualInputNode(input: String, override var output: String) : Node() {
    var firstSource: String
    var secondSource: String

    init  {
        val inputs = input.split(keyword()).map { it.trim() }
        firstSource = inputs[0]
        secondSource = inputs[1]
    }

    override fun process(known: HashMap<String, Int>):Int? {
        val one = known[firstSource]
        var two = known[secondSource]

        if (two == null) {
            try {
                two = secondSource.toInt()
            } catch (nfe: NumberFormatException) {}

        }

        if (one != null && two != null) {
            return math(one, two)
        } else {
            return null
        }
    }

    abstract fun math(one: Int, two:Int): Int
    abstract fun keyword(): String
}

class AndNode(input: String, output: String) : DualInputNode(input, output) {

    override fun math(one: Int, two: Int): Int {
        return one.and(two)
    }

    override fun keyword(): String {
        return "AND"
    }
}

class OrNode(input: String, output: String) : DualInputNode(input, output) {
    override fun math(one: Int, two:Int): Int {
        return one.or(two)
    }

    override fun keyword(): String {
        return "OR"
    }
}

class LeftShiftNode(input: String, output: String) : DualInputNode(input, output) {
    override fun math(one: Int, two:Int): Int {
        return one.shl(two)
    }

    override fun keyword(): String {
        return "LSHIFT"
    }
}

class RightShiftNode(input: String, output: String) : DualInputNode(input, output) {
    override fun math(one: Int, two:Int): Int {
        return one.shr(two)
    }

    override fun keyword(): String {
        return "RSHIFT"
    }
}