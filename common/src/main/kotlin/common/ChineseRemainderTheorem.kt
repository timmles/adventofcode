package common

// A Kotlin program to demonstrate working of Chinese remainder Theorem
// This code is contributed by nikita Tiwari.
// https://www.geeksforgeeks.org/chinese-remainder-theorem-set-2-implementation/

object ChineseRemainderTheorem {

  /**
   * Returns modulo inverse of a
   * with respect to m using Extended Euclid Algorithm.
   * Refer to this post for details: https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/
   */
  fun inv(a: Long, m: Long): Long {
    var a = a
    var m = m
    val m0 = m
    var t: Long
    var q: Long
    var x0 = 0L
    var x1 = 1L
    if (m == 1L) return 0

    // Apply extended Euclid Algorithm
    while (a > 1) {
      // q is quotient
      q = a / m
      t = m

      // m is remainder now, process
      // same as euclid's algo
      m = a % m
      a = t
      t = x0
      x0 = x1 - q * x0
      x1 = t
    }

    // Make x1 positive
    if (x1 < 0) x1 += m0
    return x1
  }

  /**
   * k is size of num[] and rem[].
   * Returns the smallest number
   * x such that:
   * x % num[0] = rem[0],
   * x % num[1] = rem[1],
   * ..................
   * x % num[k-2] = rem[k-1]
   * Assumption: Numbers in num[] are pairwise coprime (gcd for every pair is 1)
   */
  fun calculate(num: LongArray, rem: LongArray): Long {
    assert(num.size == rem.size)

    // Compute product of all numbers
    val prod = num.fold(1L) { acc, i -> acc * i }

    // Initialize result
    var sum = 0L

    // Apply above formula
    for (i in num.indices) {
      val pp = prod / num[i]
      sum += rem[i] * inv(pp, num[i]) * pp
    }
    return sum % prod
  }
}
