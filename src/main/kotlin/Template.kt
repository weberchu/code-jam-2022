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

    return "1"
}

//private fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2022-1.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
