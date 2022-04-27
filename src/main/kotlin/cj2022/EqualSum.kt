package cj2022

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

// testing tool
private lateinit var reader: BufferedReader
private lateinit var writer: BufferedWriter

fun main() {
    // testing tool
    val testingTool = Runtime.getRuntime().exec("python3 src/main/resources/local_testing_tool.py")
    reader = BufferedReader(InputStreamReader(testingTool.inputStream))
    writer = BufferedWriter(OutputStreamWriter(testingTool.outputStream))

    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        processCase()
    }
}

private fun processCase() {
    val count = nextLine().toInt()

    val maxPow = 29

    val guess = mutableListOf<Long>()
    for (i in 0 until count) {
        if (i <= maxPow) {
            guess.add(2.0.pow(i).toLong())
        } else {
            guess.add(600L + i)
        }
    }

//    println("guess = ${guess}")

//    val guess = (0L until count)
//        .toList()
//        .map { 2.0.pow(it.toDouble()).toLong()}
//        .map { 1000000000 - it }
    printLine(guess.joinToString(" ") { it.toString() })

    val givenLongs = nextLine().split(" ").map { it.toLong() }

    val fullset = (guess + givenLongs).sortedDescending()
    val target = fullset.sum() / 2
//    println("target = ${target}")

    val result = tryNumber(fullset, target)

//    println("result = ${result}")

    val answer = result.joinToString(" ") { it.toString() }

    println("anwer sum = ${result.sum()}")

    printLine(answer)
}

private fun tryNumber(longList: List<Long>, target: Long): List<Long> {
    println("t = $target, longList = ${longList}")
    if (longList.size == 0) {
        return emptyList()
    } else if (longList.size == 1 && longList[0] == target) {
        return longList
    }

    for (i in longList.indices) {
        if (longList[i] == target) {
            println("FOUND ${longList[i]}")
            return listOf(longList[i])
        } else if (longList[i] < target) {
            println("Trying = ${longList[i]}")
            val result = tryNumber(longList.subList(0, i) + longList.subList(i + 1, longList.size), target - longList[i])
            if (result.isNotEmpty()) {
                return result + longList[i]
            }
        }
    }

    return emptyList()
}


// IO
//private fun printLine(line: String) {
//    println(line)
//}
//
//private fun nextLine(): String {
//    val line = readLine()
//    if (line == "-1") {
//        throw Exception("Judge error")
//    }
//    return line!!
//}


private fun nextLine(): String {
    val line = reader.readLine()
    if (line == "-1") {
        throw Exception("Judge error")
    }
    println("[TestingTool] $line")
    return line
}

private fun printLine(line: String) {
    println("[Code] $line")
    writer.write(line)
    writer.newLine()
    writer.flush()
}
