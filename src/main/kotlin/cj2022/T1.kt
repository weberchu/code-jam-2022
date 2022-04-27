package cj2022

//import java.io.File

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        val result = processCase()
        println("Case #$case: ${result}")
    }
}

private fun processCase(): String {
    val count = nextLine()
    val pancakes = nextLine().split(" ").map { it.toInt() }.toMutableList()

    var paidCount = 0
    var maxLevel = 1

    while (pancakes.isNotEmpty()) {
        val first = pancakes.first()
        val last = pancakes.last()
        if (first <= last) {
            pancakes.removeAt(0)
            if (first >= maxLevel) {
                paidCount++
                maxLevel = first
            }
        } else {
            pancakes.removeLast()
            if (last >= maxLevel) {
                paidCount++
                maxLevel = last
            }
        }
    }

    return paidCount.toString()
}

private fun nextLine(): String {
    return readLine()!!
}


//private val lines = File("src/main/resources", "input2022-t1.txt").readLines()
//private var linePointer = 0
//private fun nextLine(): String {
//    return lines[linePointer++]
//}
