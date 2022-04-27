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
    val dinerCount = nextLine().toInt()
    val diners = nextLine().split(" ").map { it.toInt() }
    val maxCount = diners.maxOrNull()!!
    var minMinute = maxCount

    for (maxPancake in maxCount - 1 downTo 1) {
        var minuteRequired = 0
        diners.forEach { diner ->
            if (diner > maxPancake) {
                // minute spent on splitting
                minuteRequired += (diner - 1) / maxPancake
            }
        }
        minuteRequired += maxPancake

        if (minuteRequired < minMinute) {
            minMinute = minuteRequired
        }

    }

    return minMinute.toString()
}

//fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2015-2.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
