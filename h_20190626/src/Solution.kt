import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
// Complete the matrixRotation function below.
fun matrixRotation(matrix: Array<Array<Int>>, r: Int): Unit {
    val (m, n) = getDimension(matrix)

}

fun getDimension(matrix: Array<Array<Int>>) : Pair<Int, Int> {
    val m = matrix.size
    val n = matrix[0].size
    println("getDimension m:$m, n:$n")
    return m to n
}

fun main(args: Array<String>) {
    println("started")
    val mnr = readLine()!!.trimEnd().split(" ")

    val m = mnr[0].toInt()

    val n = mnr[1].toInt()

    val r = mnr[2].toInt()

    val matrix = Array<Array<Int>>(m, { Array<Int>(n, { 0 }) })

    for (i in 0 until m) {
        matrix[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }
    println("main m:$m, n:$n")
    matrixRotation(matrix, r)
}
