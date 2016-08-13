package com.github.fedeoasi.strings

object MatchedParentheses {
  def matches(s: String): Boolean = {
    val result = s.foldLeft(0) { case (acc, c) =>
      if (acc < 0) acc else check(acc, c)
    }
    result == 0
  }

  private def check(openCount: Int, c: Char): Int = {
    c match {
      case '(' => openCount + 1
      case ')' => openCount - 1
      case _ => openCount
    }
  }
}
