package solutions.week1

fun bitwiseComplement(N: Int): Int {
    if(N==0) return 1
    var A = 0
    while(N>A) {
        A = (A shl 1) + 1
    }
    return A xor N
}