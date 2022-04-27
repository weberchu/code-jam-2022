package cj2015

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        val result = processCase()
        println("Case #$case: ${result}")
    }
}

private fun processCase(): String {
    val split = nextLine().split(" ")
//    val smax = split[0].toInt()
    val sarray = split[1].toCharArray().map { c -> c.toInt() - 48 }

    var totalStoodUp = 0
    var friendsNeeded = 0

    sarray.forEachIndexed { sLevel, count ->
        if (sLevel > totalStoodUp) {
            val extra = sLevel - totalStoodUp
            totalStoodUp += extra
            friendsNeeded += extra
        }

        totalStoodUp += count
    }

    return friendsNeeded.toString()
}

private fun nextLine(): String {
    return readLine()!!
}


//val lines = File("src/main/resources", "input2015-1.txt").readLines()
//var linePointer = 0
//fun nextLine(): String {
//    return lines[linePointer++]
//}

