package cj2022

import java.io.File
import kotlin.math.min

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        val result = processCase()
        println("Case #$case:${result}")
    }
}

private fun processCase(): String {
    val printer1 = nextLine().split(" ").map { it.toInt() }
    val printer2 = nextLine().split(" ").map { it.toInt() }
    val printer3 = nextLine().split(" ").map { it.toInt() }

    val minC = min(min(printer1[0], printer2[0]), printer3[0])
    val minM = min(min(printer1[1], printer2[1]), printer3[1])
    val minY = min(min(printer1[2], printer2[2]), printer3[2])
    val minK = min(min(printer1[3], printer2[3]), printer3[3])

    return if (minC + minM + minY + minK < 1000000) {
        " IMPOSSIBLE"
    } else {
        var remaining = 1000000
        var output = ""

        for (colour in listOf(minC, minM, minY, minK)) {
            if (remaining > colour) {
                remaining -= colour
                output += " $colour"
            } else {
                output += " $remaining"
                remaining = 0
            }
        }

        output
    }
}

//fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2022-printing.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
