import kotlin.test.assertEquals

// 1248. Count Number of Nice Subarrays
// https://leetcode.com/contest/weekly-contest-161/problems/count-number-of-nice-subarrays/

fun main() {
    val q2 = Q2()
    println("starting")
    testCases(q2::solve2)
    // testCases(q2::numberOfSubarrays)

}

fun testCases(algorithm: (IntArray, Int) -> Int){
    // assertEquals(2, algorithm(intArrayOf(1, 1, 2, 1, 1), 3))
    // assertEquals(0, algorithm(intArrayOf(2, 4, 6), 1))
    // assertEquals(16, algorithm(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))
    algorithm(intArrayOf(2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2), 2)
}

class Q2 {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val oddNumbersIndex = nums.mapIndexed { index, i -> if (i % 2 != 0) index else 0 }.filter { it != 0 }

        if (k > oddNumbersIndex.size)
            return 0
        else if (k == oddNumbersIndex.size)
            return 1

        val oddPicker = oddNumbersIndex.size - k + 1
        for (pointer in 0 until oddPicker) {
            val start = oddNumbersIndex[pointer]
            val end = oddNumbersIndex[pointer + k - 1]

        }



        return -1
    }


    fun solve2(nums: IntArray, k: Int): Int {
        var oddNumbersSize = 0
        for (num in nums) {
            if (num % 2 != 0) oddNumbersSize++
        }

        if (k > oddNumbersSize)
            return 0
        else if (k == oddNumbersSize)
            return 1


        for (startOddIndex in nums.indices){
            if (nums[startOddIndex] % 2 != 0) { // if it is an odd number
                var endOddIndex = startOddIndex
                var oddCounter = 1

                while (oddCounter < k && endOddIndex < nums.size - 1){
                    endOddIndex++
                    if (nums[endOddIndex] % 2 != 0) oddCounter++
                }

                if (endOddIndex >= nums.size - 1) break


                println("startOddIndex:$startOddIndex endOddIndex:$endOddIndex")
                if (endOddIndex == nums.size - 1) {
                    println("reading the end, endOddIndex:$endOddIndex")
                }

            }
        }

        return -1
    }
}