package solutions.week1

class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        val visited = mutableSetOf<Int>()
        val used = mutableSetOf<Pair<Int, Int>>()
        for(num in nums) {
            if(k==0 && num in visited) {
                used.add(Pair(num, num))
                continue
            }
            if(num+k in visited) {
                used.add(Pair(num, num+k))
            }
            if(num-k in visited) {
                used.add(Pair(num-k, num))
            }
            visited.add(num)
        }
        return used.size
    }
}