package com.github.fedeoasi.arrays

import scala.annotation.tailrec

object SortColors {
  def sortColors(nums: Array[Int]): Unit = {
    val colors = 3 // means that we have n colors, [0, 1, .., n-1]

    @tailrec
    def loop(start: Int, end: Int, currentColor: Int): Unit = {
      //println(s"[$start, $end] color=$currentColor ${nums.toList}")
      if (currentColor >= colors) {

      } else if (end < start) {
        loop(start, nums.length - 1, currentColor + 1)
      } else {

        if (nums(start) != currentColor && nums(end) == currentColor) {
          val oldStart = nums(start)
          nums(start) = nums(end)
          nums(end) = oldStart
          //println(s"flipped positions $start and $end. newArray=${nums.toSeq}")
        }

        val newStart = if (nums(start) != currentColor) start else start + 1
        val newEnd = if (nums(end) == currentColor) end else end - 1
        loop(newStart, newEnd, currentColor)
      }
    }

    loop(0, nums.length - 1, 0)
  }
}
