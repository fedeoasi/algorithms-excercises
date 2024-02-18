package com.github.fedeoasi

object LongestSubstringWithoutRepeatingCharacters {
  def substring[T](array: Array[T]): Option[Array[T]] = {
    solution(array, None, 0, 0, Set.empty[T]).map { solution =>
      array.slice(solution.start, solution.end)
    }
  }

  private def solution[T](
    array: Array[T],
    currentBest: Option[Solution],
    start: Int,
    end: Int,
    seen: Set[T]): Option[Solution] = {

    if (end >= array.length) {
      val newSolution = Solution(start, end)
      if (newSolution.nonEmpty && !currentBest.exists(_.length > newSolution.length)) Some(newSolution) else currentBest
    } else {
      val current = array(end)
      if (seen.contains(current)) {
        val newSeen = seen - array(start)
        val newSolution = Solution(start, end)
        val newBest = if (!currentBest.exists(_.length > newSolution.length)) Some(newSolution) else currentBest
        solution(array, newBest, start + 1, start + 1, newSeen)
      } else {
        val newSeen = seen + current
        solution(array, currentBest, start, end + 1, newSeen)
      }
    }
  }

  case class Solution(start: Int, end: Int) { // start is inclusive, end is not
    def length: Int = end - start

    def nonEmpty: Boolean = length > 0
  }
}
