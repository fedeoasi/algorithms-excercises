package com.github.fedeoasi.problems

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * Problem:
 *
 * Given a screen with all pixels having one of two colors. Now I will click on a random pixel.
 * Then that pixel & all the adjacent pixels with same color should change the color to the second color.
 * adjacent = vertically or horizontally above or blow.
 */
class ChangeColorSpec extends FunSpec with ShouldMatchers {
  it("should change the color of a single 1 in the middle") {
    val cc = new ChangeColor(
      Array(
        Array(0, 0, 0),
        Array(0, 1, 0),
        Array(0, 0, 0)
      )
    )
    cc.changeColor(1, 1)
    cc.getMatrix should be{
      Array(
        Array(0, 0, 0),
        Array(0, 0, 0),
        Array(0, 0, 0)
      )
    }
  }

  it("should propagate the color change from a corner") {
    val cc = new ChangeColor(
      Array(
        Array(0, 0, 0),
        Array(0, 1, 0),
        Array(0, 0, 0)
      )
    )
    cc.changeColor(0, 0)
    cc. getMatrix should be{
      Array(
        Array(1, 1, 1),
        Array(1, 1, 1),
        Array(1, 1, 1)
      )
    }
  }

  it("should change the color change from the boundary") {
    val cc = new ChangeColor(
      Array(
        Array(0, 0, 0),
        Array(0, 1, 0),
        Array(0, 0, 0)
      )
    )
    cc.changeColor(2, 1)
    cc.getMatrix should be{
      Array(
        Array(1, 1, 1),
        Array(1, 1, 1),
        Array(1, 1, 1)
      )
    }
  }


}
