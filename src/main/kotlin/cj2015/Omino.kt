package cj2015

import java.io.File

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        val result = processCase()
        println("Case #$case: ${result}")
    }
}

private fun processCase(): String {
    val split = nextLine().split(" ")
    val x = split[0].toInt()
    val r = split[1].toInt()
    val c = split[2].toInt()

    val minWidth = x / 2 + x % 2

    return if (x >= 7) {
        return "RICHARD"
    } else if (x > r && x > c) {
        "RICHARD"
    } else if (r < minWidth || c < minWidth) {
        "RICHARD"
    } else {
        if ((r * c) % x == 0) {
            "GABRIEL"
        } else {
            "RICHARD"
        }
    }
}

//fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2015-4.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
