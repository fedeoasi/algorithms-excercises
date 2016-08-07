package com.github.fedeoasi.numbers

class ClockTick {
  def value(tick: Long): Long = {
    val g = group(tick)
    val priorBoundary = boundary(g - 1)
    val size = Math.pow(2, g).toLong * 3
    val offset = tick - priorBoundary
    size - offset + 1
  }

  def group(tick: Long): Long = {
    val preGroup = log2(tick / 3 + 1).toLong - 1
    if (!isBoundary(tick, preGroup)) preGroup + 1 else preGroup
  }

  def boundary(group: Long): Long = 3 * (Math.pow(2, group + 1).toLong - 1)

  def isBoundary(tick: Long, group: Long): Boolean = tick == boundary(group)

  import scala.math.log
  private def log2(x: Double): Double = log(x) / log(2)
}
