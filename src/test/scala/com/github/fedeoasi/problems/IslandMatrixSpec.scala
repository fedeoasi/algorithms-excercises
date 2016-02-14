package com.github.fedeoasi.problems

import org.scalatest.Matchers
import org.scalatest.FunSpec

/**
 * Problem:
 * There is an island which is represented by square matrix NxN.
 * A person on the island is standing at any given co-ordinates (x,y).
 * He can move in any direction one step right, left, up, down on the island. If he steps outside the island, he dies.
 * Let island is represented as (0,0) to (N-1,N-1) (i.e NxN matrix) & person is standing at given co-ordinates (x,y).
 * He is allowed to move n steps on the island (along the matrix).
 * What is the probability that he is alive after he walks n steps on the island?
 */
class IslandMatrixSpec extends FunSpec with Matchers {
  it("should compute the probability for a step in a 1x1 matrix") {
    val island = new IslandMatrix(1, 1)
    island.probabilityOfAlive(0, 0, 1) shouldBe 0.0f
  }

  it("should compute the probability for a step in a 2x2 matrix") {
    val island = new IslandMatrix(2, 2)
    island.probabilityOfAlive(0, 0, 1) shouldBe 0.5f
    island.probabilityOfAlive(0, 1, 1) shouldBe 0.5f
    island.probabilityOfAlive(1, 0, 1) shouldBe 0.5f
    island.probabilityOfAlive(1, 1, 1) shouldBe 0.5f
  }

  it("should compute the probability for two steps in a 2x2 matrix") {
    val island = new IslandMatrix(2, 2)
    island.probabilityOfAlive(0, 0, 2) shouldBe 0.25f
    island.probabilityOfAlive(0, 1, 2) shouldBe 0.25f
    island.probabilityOfAlive(1, 0, 2) shouldBe 0.25f
    island.probabilityOfAlive(1, 1, 2) shouldBe 0.25f
  }

  it("should compute the probability for three steps in a 2x2 matrix") {
    val island = new IslandMatrix(2, 2)
    island.probabilityOfAlive(0, 0, 3) shouldBe 0.125f
    island.probabilityOfAlive(0, 1, 3) shouldBe 0.125f
    island.probabilityOfAlive(1, 0, 3) shouldBe 0.125f
    island.probabilityOfAlive(1, 1, 3) shouldBe 0.125f
  }
}
