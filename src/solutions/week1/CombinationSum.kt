package solutions.week1

import kotlin.test.assertTrue

class CombinationSum {
    private val sums = mutableListOf<List<Int>>()
    /**
     * A simple backtracking algorithm is used. If target == 0 -> we have the sum => add the current list to output
     * If target<0 => Backtrack
     * Else => Iterate through each element, add it to a list and recursively call backtrack().
     */
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        backtrack(candidates, target, 0, mutableListOf())
        return sums
    }

    private fun backtrack(candidates: IntArray, target: Int, index: Int, used: List<Int>) {
        println("backtrack($target, $index, $used)")
        if (target < 0) return
        if (target == 0) {
            println("Adding $used")
            sums.add(used.toList())
            return
        }
        val cur = used.toMutableList()
        for (i in index until candidates.size) {
            cur.add(candidates[i])
            backtrack(candidates, target - candidates[i], i, cur)
            cur.removeAt(cur.lastIndex)
        }
    }
}


// Testing against examples
// Example 1:
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//
//Example 2:
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//
//Example 3:
//
//Input: candidates = [2], target = 1
//Output: []
//
//Example 4:
//
//Input: candidates = [1], target = 1
//Output: [[1]]
//
//Example 5:
//
//Input: candidates = [1], target = 2
//Output: [[1,1]]
fun main() {
    val example1 = CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7)
    val example2 = CombinationSum().combinationSum(intArrayOf(2, 3, 5), 8)
    val example3 = CombinationSum().combinationSum(intArrayOf(2), 1)
    val example4 = CombinationSum().combinationSum(intArrayOf(1), 1)
    val example5 = CombinationSum().combinationSum(intArrayOf(1), 2)
    println("Output 1: $example1")
    assertTrue { example1.size == 2 }
    assertTrue { example1.contains(listOf(2, 2, 3)) }
    assertTrue { example1.contains(listOf(7)) }
    println("Output 2: $example2")
    assertTrue { example2.size == 3 }
    assertTrue { example2.contains(listOf(2, 2, 2, 2)) }
    assertTrue { example2.contains(listOf(2, 3, 3)) }
    assertTrue { example2.contains(listOf(3, 5)) }
    println("Output 3: $example3")
    assertTrue { example3.isEmpty() }
    println("Output 4: $example4")
    assertTrue { example4.size == 1 }
    assertTrue { example4.contains(listOf(1)) }
    println("Output 5: $example5")
    assertTrue { example5.size == 1 }
    assertTrue { example5.contains(listOf(1, 1)) }
}