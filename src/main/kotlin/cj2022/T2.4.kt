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

    return findMin(allProducts, 0, -1L).toString()
}

private fun findMin(products: List<Pair<Long, Long>>, currentLevel: Long, mustEnd: Long): Long {

    if (products.size < 10) {
        val first = products[0].first
        val last = products[0].second

        val firstFirst = abs(currentLevel - first) + abs(first - last)
        val lastFirst = abs(currentLevel - last) + abs(first - last)

        val remain = products.subList(1, products.size)

        return if (products.size == 1) {
            if (mustEnd == -1L) {
                min(firstFirst, lastFirst)
            } else {
                if (first == mustEnd) {
                    lastFirst
                } else if (last == mustEnd) {
                    firstFirst
                } else {
                    throw Exception("Cannot find mustEnd $mustEnd")
                }
            }
        } else {
            min(
                firstFirst + findMin(remain, last, mustEnd),
                lastFirst + findMin(remain, first, mustEnd),
            )
        }
    } else {
        val mid = products.size / 2
        val firstList = products.subList(0, mid)
        val secondList = products.subList(mid, products.size)

        return min(
            findMin(firstList, currentLevel, firstList[mid-1].first) + findMin(secondList, firstList[mid-1].first, mustEnd),
            findMin(firstList, currentLevel, firstList[mid-1].second) + findMin(secondList, firstList[mid-1].second, mustEnd)
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
