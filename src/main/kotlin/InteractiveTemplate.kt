import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

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

    val guess = (1..count).toList().joinToString(" ") { it.toString() }
    printLine(guess)

    val givenInts = nextLine().split(" ").map { it.toInt() }
    val answer = givenInts.joinToString(" ") { it.toString() }

    printLine(answer)
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
