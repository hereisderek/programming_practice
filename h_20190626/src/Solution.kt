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

// Complete the matrixRotation function below.
fun matrixRotation(matrix: Array<Array<Int>>, r: Int): Unit {


}

fun main(args: Array<String>) {
    val mnr = readLine()!!.trimEnd().split(" ")

    val m = mnr[0].toInt()

    val n = mnr[1].toInt()

    val r = mnr[2].toInt()

    val matrix = Array<Array<Int>>(m, { Array<Int>(n, { 0 }) })

    for (i in 0 until m) {
        matrix[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    matrixRotation(matrix, r)
}
