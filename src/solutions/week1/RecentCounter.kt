package solutions.week1

import kotlin.test.assertEquals

/**
 * A simple queue is used and for  every insertion, we remove all previous calls done before t-3000
 * Time Complexity:-
 * Best case: O(1)
 * Worst case: O(n) where n is the no. of ping calls made earlier.
 * Note that n can't be more than 3000 as all calls will be in increasing order
 * As such, worst complexity for every `ping` call won't be more than O(3000)
 */
class RecentCounter {
    private val queue = mutableListOf<Int>()
    fun ping(t: Int): Int {
        queue.add(t)
        while (queue[0] < t - 3000) queue.removeAt(0)
        return queue.size
    }
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */


// Test RecentCounter with example case
// Example 1: Input
//["RecentCounter", "ping", "ping", "ping", "ping"]
//[[], [1], [100], [3001], [3002]]
//Output
//[null, 1, 2, 3, 3]
//
//Explanation
//RecentCounter recentCounter = new RecentCounter();
//recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
//recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
//recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
//recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
fun main() {
    val recentCounter = RecentCounter()
    assertEquals(1, recentCounter.ping(1))
    assertEquals(2, recentCounter.ping(100))
    assertEquals(3, recentCounter.ping(3001))
    assertEquals(3, recentCounter.ping(3002))
}