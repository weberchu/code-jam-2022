package cj2022

import java.io.File
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        val result = processCase()
        println("Case #$case: ${result}")
    }
}

private fun processCase(): String {
    val np = nextLine().split(" ").map { it.toInt() }

    val allProducts = mutableListOf<List<Long>>()

    for (i in 0 until np[0]) {
        val products = nextLine().split(" ").map { it.toLong() }.sorted()
        allProducts.add(products)
    }

    var currentLevel = 0L
    var pressed = 0L

    for (i in 0 until np[0]) {
        val first = allProducts[i].first()
        val last = allProducts[i].last()

        if (currentLevel <= first) {
            pressed += last - currentLevel
            currentLevel = last
        } else if (currentLevel > last) {
            pressed += currentLevel - first
            currentLevel = first
        } else {
            // middle
            val goLastFirst = if (currentLevel - first > last - currentLevel) {
                true
            } else if ((currentLevel - first < last - currentLevel)) {
                false
            } else {
                if (i + 1 >= np[0]) {
                    true
                } else {
                    val nFirst = allProducts[i+1].first()
                    val nLast = allProducts[i+1].last()

                    val minNFirst = min(abs(first - nFirst), abs(first - nLast))
                    val minNLast = min(abs(last - nFirst), abs(last - nLast))

                    minNFirst < minNLast
                }
            }

            if (goLastFirst) {
                // go last first
                pressed += (last - currentLevel) + (last - first)
                currentLevel = first
            } else {
                pressed += (currentLevel - first) + (last - first)
                currentLevel = last
            }
        }
        println("i = ${i} $currentLevel $pressed")
    }

    return pressed.toString()
}

//private fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2022-t2.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
