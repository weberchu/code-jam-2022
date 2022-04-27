package cj2022

import java.io.File

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        processCase(case)
    }
}

private fun processCase(case: Int) {
    val split = nextLine().split(" ")
    val r = split[0].toInt()
    val c = split[1].toInt()

    println("Case #${case}:")

    for (row in 0 until r) {
        val topLine = if (row == 0) {
            ".." + "+-".repeat(c - 1) + "+"
        } else {
            "+-".repeat(c) + "+"
        }
        val middleLine = if (row == 0) {
            ".." + "|.".repeat(c - 1) + "|"
        } else {
            "|.".repeat(c) + "|"
        }
        println(topLine)
        println(middleLine)
    }

    println("+-".repeat(c) + "+")
}

//fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2022-punched-card.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
