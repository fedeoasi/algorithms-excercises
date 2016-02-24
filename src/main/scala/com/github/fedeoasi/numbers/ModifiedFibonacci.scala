package com.github.fedeoasi.numbers

class ModifiedFibonacci(first: Int, second: Int) {
  def compute(n: Int): BigInt = {
    if (n < 1) {
      throw new IllegalArgumentException
    }
    if (n == 1) {
      first
    } else if (n == 2) {
      second
    } else {
      var a = BigInt(first)
      var b = BigInt(second)
      var tmp = BigInt(0)
      var i = 2
      while (i < n) {
        val bSquared = b * b
        tmp = a + bSquared
        a = b
        b = tmp
        i += 1
      }
      tmp
    }
  }
}

