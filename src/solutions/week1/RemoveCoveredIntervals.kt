package solutions.week1

class RemoveCoveredIntervals {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        var count = 0
        intervals.sortBy { it[0] }
        var left = -1
        var right = -1
        for ((a, b) in intervals) {
            if (a > left && b > right) {
                left = a
                count += 1
            }
            right = Math.max(right, b)
        }
        return count
    }
}