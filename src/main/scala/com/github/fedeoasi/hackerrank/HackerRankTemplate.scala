package com.github.fedeoasi.hackerrank

object HackerRankTemplate {
  object Solution {
    def computeSolution(): Int = ???

    def main(args: Array[String]) {
      val lines = io.Source.stdin.getLines()
      val T = lines.take(1).next().toInt
      1 to T foreach { i =>
        println(computeSolution())
      }
    }

    def readArray(input: Iterator[String]): Array[Int] = {
      input.take(1).next().split(" ").map(_.toInt).toArray
    }

    def readInt(input: Iterator[String]): Int = input.take(1).next().toInt

    def readTwoInts(input: Iterator[String]): (Int, Int) = {
      val numbers = readArray(input)
      (numbers(0), numbers(1))
    }
  }
}
