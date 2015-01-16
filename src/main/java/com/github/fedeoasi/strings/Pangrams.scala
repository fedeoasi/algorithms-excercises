package com.github.fedeoasi.strings

object Pangrams {
  val alphabetSize = 26

  def isPangram(s: String): Boolean = {
    val counts = new Array[Int](alphabetSize)
    s.toLowerCase.foreach { c =>
      val offset = c - 'a'
      if(offset >= 0 && offset <= alphabetSize) {
        counts(offset) += 1
      }
    }
    !counts.exists(_ == 0)
  }
}
