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
    val line = nextLine()
    var output = ""
    for (i in line.indices) {
        var shouldDouble = false

        for (j in i+1 until line.length) {
            if (line[j] < line[i]) {
                break
            } else if (line[j] > line[i]) {
                shouldDouble = true
                break
            }
        }

        output += if (shouldDouble) {
            line[i].toString() + line[i]
        } else {
            line[i]
        }
    }

    return output
}

//private fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2022-double.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
