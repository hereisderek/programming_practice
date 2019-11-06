import kotlin.test.assertEquals

val solution = Solution()


fun main(){
    // test(2, "xy", "yx")
    // test(2, "xyx", "yxx")
    test(1, "xx", "yy")
    // test(4, "xxyyxyxyxx", "xyyxyxxxyx")
}

fun test(expected: Int, s1: String, s2: String) {
    assertEquals(expected, solution.minimumSwap(s1, s2), "$s1 - $s2")
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