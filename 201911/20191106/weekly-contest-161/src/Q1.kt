import kotlin.system.measureNanoTime
import kotlin.test.assertEquals




fun main(){
    val solution = Solution()
    val test1 = solution::minimumSwap
    val test2 = solution::minimumSwap_124


    print("test1 took: ${test(test1)}")
    print("test2 took: ${test(test2)}")
}

fun test(action: (String, String) -> Int) : Long = measureNanoTime {
    for(i in 0 .. 0) {
        test(2, "xy", "yx", action)
        test(2, "xyx", "yxx", action)
        test(1, "xx", "yy", action)
        test(4, "xxyyxyxyxx", "xyyxyxxxyx", action)
    }
}

fun test(expected: Int, s1: String, s2: String, action: (String, String) -> Int) {
    assertEquals(expected, action(s1, s2), "$s1 - $s2")
}

class Solution {
    /*
    * Runtime: 136 ms
    * Memory Usage: 31.5 MB
    * */
    fun minimumSwap(s1: String, s2: String): Int {
        val length = s1.length
        val diff = IntArray(length) { s1[it] - s2[it] }
        var minus = 0
        var zero = 0
        var plus = 0
        diff.forEach {
            when(it){
                0 -> zero ++
                1 -> plus ++
                -1 -> minus ++
            }
        }

        val counter = minus / 2 + plus / 2
        val mod = minus % 2 + plus % 2
        return when(mod){
            0 -> counter
            2 -> counter + 2
            else -> -1
        }
    }


    fun minimumSwap_124(s1: String, s2: String): Int {
        var cx = 0
        var cy = 0
        var cnt = 0
        for (i in s1.indices) {
            if (s1[i] == s2[i]) continue
            if (s1[i] == 'x') {
                if (cx == 1) cnt++
                cx = cx xor 1
            }
            else {
                if (cy == 1) cnt++
                cy = cy xor 1
            }
        }

        return when ((cx shl 1) or cy) {
            0 -> cnt
            3 -> cnt + 2
            else -> -1
        }
    }
}