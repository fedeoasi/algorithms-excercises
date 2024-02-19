package com.github.fedeoasi.arrays

object MinimumWindowSubstring {
  def minWindow(s: String, t: String): String = {
    val maybeSolution = solution(s, t)
    //println(maybeSolution)
    maybeSolution.map(solution => s.slice(solution.start, solution.end)).getOrElse("")
  }

  case class Solution(start: Int, end: Int) {
    def length: Int = end - start
  }

  private def solution(s: String, t: String): Option[Solution] = {
    val distinctNeededChars = t.toSet

    def recur(start: Int, end: Int, neededChars: Histogram, maybeSolution: Option[Solution], count: Int): Option[Solution] = {
      //println(s"[$start, $end] $neededChars, $maybeSolution")

      if (end > s.length) {
        maybeSolution
      } else {
        val newNeededChars = if (end < s.length) {
          val currentChar = s(end)
          neededChars.remove(currentChar)
        } else {
          neededChars
        }

        if (newNeededChars.neededCount == 0) {
          //println(s"found solution: [$start, $end]")
          val sol = Solution(start, end + 1)
          val newSolution = if (maybeSolution.exists(_.length < sol.length)) maybeSolution else Some(sol)
          val newNeededChars = if (distinctNeededChars.contains(s(start))) neededChars.add(s(start)) else neededChars
          recur(start + 1, end, newNeededChars, newSolution, count + 1)
        } else {
          // need to expand right-ward
          recur(start, end + 1, newNeededChars, maybeSolution, count + 1)
        }
      }
    }
    recur(0, 0, Histogram(t), None, 0)
  }

  private class Histogram private(underlying: Map[Char, Int], neededChars: Int) {
    def add(char: Char): Histogram = {
      underlying.get(char) match {
        case Some(count) =>
          val newNeededChars = if (count >= 0) neededChars + 1 else neededChars
          new Histogram(underlying.updated(char, count + 1), newNeededChars)
        case None => this
      }
    }

    def remove(char: Char): Histogram = {
      underlying.get(char) match {
        case Some(count) =>
          val newNeededChars = if (count > 0) neededChars - 1 else neededChars
          new Histogram(underlying.updated(char, count - 1), newNeededChars)
        case None => this
      }
    }

    def neededCount: Int = neededChars
  }

  private object Histogram {
    def apply(s: String): Histogram = {
      val neededChars = s.toSeq.groupBy(identity).map { case (k, v) => (k, v.length) }
      new Histogram(neededChars, neededChars.values.sum)
    }
  }
}
