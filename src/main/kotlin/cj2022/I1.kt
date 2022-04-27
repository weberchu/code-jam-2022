package cj2022

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.random.Random

// testing tool
private lateinit var reader: BufferedReader
private lateinit var writer: BufferedWriter

fun main() {
    // testing tool
    val testingTool = Runtime.getRuntime().exec("python3 src/main/resources/local_testing_tool_i1.py")
    reader = BufferedReader(InputStreamReader(testingTool.inputStream))
    writer = BufferedWriter(OutputStreamWriter(testingTool.outputStream))

    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        processCase()
    }
}

private val countList = mutableListOf<Int>()

private fun processCase() {
    var count = 1

    printLine("00000000")

    var result = nextLine().toInt()
    if (result == 0) {
        return
    }

    while (result > 0) {
        val guess = when (result) {
            8 -> "11111111"
            else -> randomOnes(result)
//            7 -> "11111110"
//            6 -> "11111100"
//            5 -> "11111000"
//            4 -> "11110000"
//            3 -> "11100000"
//            2 -> "11000000"
//            else -> "00000001"
        }

        printLine(guess)
        result = nextLine().toInt()

        count++
    }

    countList.add(count)

    println("COUNT = ${countList} done = ${countList.size} avg = ${countList.average()}")
}

fun randomOnes(count: Int): String {
    val num = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
    while (num.sum() < count) {
        val pos = Random.nextInt(0, 8)
        num[pos] = 1
    }

    return num.joinToString("")
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
