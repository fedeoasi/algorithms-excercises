package com.github.fedeoasi.combinatorics

class BinomialCoefficients(n: Int) extends Iterator[BigInt] {
  var current: BigInt = 1
  var k = 0

  override def hasNext: Boolean = k <= n

  override def next(): BigInt = {
    val oldCurrent = current
    k += 1
    current = current * (n - k + 1) / k
    oldCurrent
  }
}
