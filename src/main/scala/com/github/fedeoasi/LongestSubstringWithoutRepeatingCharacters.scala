package com.github.fedeoasi

object LongestSubstringWithoutRepeatingCharacters {
  def substring[T](array: Array[T]): Option[Array[T]] = {
    if (array.isEmpty) {
      None
    } else {
      solution(array, None, 0, 0, Set.empty[T]).map { solution =>
        array.slice(solution.start, solution.end)
      }
    }
  }

  private def solution[T](
    array: Array[T],
    currentBest: Option[Solution],
    start: Int,
    end: Int,
    seen: Set[T]): Option[Solution] = {

    if (end >= array.length) {
      if (!currentBest.exists(_.length > end - start)) Some(Solution(start, end)) else currentBest
    } else {
      val current = array(end)
      if (seen.contains(current)) {
        val newSeen = seen - array(start)
        val newBest = if (!currentBest.exists(_.length > end - start)) Some(Solution(start, end)) else currentBest
        solution(array, newBest, start + 1, start + 1, newSeen)
      } else {
        val newSeen = seen + current
        solution(array, currentBest, start, end + 1, newSeen)
      }
    }
  }

  case class Solution(start: Int, end: Int) {
    def length: Int = end - start
  }
}
