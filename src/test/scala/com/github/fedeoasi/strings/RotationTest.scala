package com.github.fedeoasi.strings

import org.scalatest.FunSpec
import org.scalatest.Matchers
import com.github.fedeoasi.strings.StringRotation._

class RotationTest extends FunSpec with Matchers {
  describe ("String Rotation Detection") {
    it ("should not consider empty strings as rotated") {
      isRotatedBy("", "", 1) shouldBe false
    }

    it ("should detect rotation by 2 backwards") {
      isRotatedBy("azonam", "amazon", 2) shouldBe true
    }

    it ("should detect rotation by 2 forwards") {
      isRotatedBy("onamaz", "amazon", 2) shouldBe true
    }

    it ("should detect rotation by 2 backwards when asking for 3") {
      isRotatedBy("azonam", "amazon", 3) shouldBe false
    }

    it ("should not detect a string that wasn't rotated") {
      isRotatedBy("zonama", "amazon", 2) shouldBe false
    }

    it ("should not detect a different string") {
      isRotatedBy("zonama", "google", 2) shouldBe false
    }

    it ("should detect equality as rotation by zero") {
      isRotatedBy("amazon", "amazon", 0) shouldBe true
    }
  }
}
