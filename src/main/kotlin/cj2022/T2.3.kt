package cj2022

import java.io.File
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val caseNumber = nextLine().toInt()
    for (case in 1..caseNumber) {
        val result = processCase()
        println("Case #$case: ${result}")
    }
}

private fun processCase(): String {
    val np = nextLine().split(" ").map { it.toInt() }

    val allProducts = mutableListOf<Pair<Long, Long>>()

    for (i in 0 until np[0]) {
        val products = nextLine().split(" ").map { it.toLong() }.sorted()
        allProducts.add(Pair(products.first(), products.last()))
    }

    var currentLevel = 0L
    var pressed = 0L

    return findMin(allProducts, 0).toString()
}

private fun findMin(products: List<Pair<Long, Long>>, currentLevel: Long): Long {
    val first = products[0].first
    val last = products[0].second

    val firstFirst = abs(currentLevel - first) + abs(first - last)
    val lastFirst = abs(currentLevel - last) + abs(first - last)

    val remain = products.subList(1, products.size)

    return if (products.size == 1) {
        min(firstFirst, lastFirst)
    } else {
        min(
            firstFirst + findMin(remain, last),
            lastFirst + findMin(remain, first),
        )
    }

}

//private fun nextLine(): String {
//    return readLine()!!
//}


private val lines = File("src/main/resources", "input2022-t2.txt").readLines()
private var linePointer = 0
private fun nextLine(): String {
    return lines[linePointer++]
}
