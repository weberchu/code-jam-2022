package cj2022

import java.io.File

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        val result = processCase()
        println("Case #$case: ${result}")
    }
}

private fun processCase(): String {
    val diceCount = nextLine().toInt()
    val dice = nextLine().split(" ").map { it.toInt() }.sorted()

    var straight = 0
    for (die in dice) {
        if (die > straight) {
            straight++
        }
    }

    return straight.toString()
}

//fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2022-dice.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
