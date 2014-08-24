package com.github.fedeoasi.numbers

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class SieveTest extends FunSpec with ShouldMatchers {
  import ErathostenesSieve._

  it("should return no prime numbers when passed 0") {
    val res = primeNumbersUpTo(0)
    res.toArray should be(Array())
  }

  it("should return no prime numbers when passed 1") {
    primeNumbersUpTo(1).toArray should be(Array())
  }

  it("should return the prime numbers up to a non prime") {
    primeNumbersUpTo(10).toArray should be(Array(2, 3, 5, 7))
  }

  it("should return the prime numbers up to a prime number") {
    primeNumbersUpTo(11).toArray should be(Array(2, 3, 5, 7))
  }

  it("should return the first primes up to 100") {
    primeNumbersUpTo(100).toArray should be(
      Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
          43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
    )
  }

//  it("times the execution for the first million primes") {
//    val start = System.currentTimeMillis()
//    primeNumbersUpTo(1000000)
//    val stop = System.currentTimeMillis()
//    println(s"primeNumbersUpTo(1000000) elapsed: ${(stop - start) / 1000} seconds")
//  }
}
