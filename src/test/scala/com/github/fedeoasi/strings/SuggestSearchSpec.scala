package com.github.fedeoasi.strings

import org.scalatest.FunSpec
import org.scalatest.Matchers
import scala.collection.JavaConverters._
import scala.io.Source

class SuggestSearchSpec extends FunSpec with Matchers {
  val emptyList = List.empty[String].asJava

  describe("Trie based suggest search") {
    it("should load an empty dictionary and find nothing") {
      val suggester = new TrieSuggestSearch
      suggester.loadDictionary(emptyList)
      suggester.suggest("he") shouldBe emptyList
    }

    describe("Single string dictionary") {
      val singleStringDictionary = List("hello").asJava
      val suggester = new TrieSuggestSearch
      suggester.loadDictionary(singleStringDictionary)

      it("should suggest the string") {
        suggester.suggest("hello") shouldBe List("hello").asJava
      }

      it("should suggest the string by a substring") {
        suggester.suggest("h") shouldBe List("hello").asJava
        suggester.suggest("he") shouldBe List("hello").asJava
        suggester.suggest("hel") shouldBe List("hello").asJava
        suggester.suggest("hell") shouldBe List("hello").asJava
      }

      it("should not suggest another string") {
        suggester.suggest("world") shouldBe emptyList
      }
    }

    describe("Single string dictionary") {
      val simpleDictionary = List("hello", "world", "worm", "wolf").asJava
      val suggester = new TrieSuggestSearch
      suggester.loadDictionary(simpleDictionary)

      it("should suggest words in the dictionary") {
        suggester.suggest("hello") shouldBe List("hello").asJava
        suggester.suggest("world") shouldBe List("world").asJava
        suggester.suggest("worm") shouldBe List("worm").asJava
        suggester.suggest("wolf") shouldBe List("wolf").asJava
      }

      it("should suggest multiple choices by prefix") {
        suggester.suggest("wo") shouldBe List("world", "worm", "wolf").asJava
        suggester.suggest("wor") shouldBe List("world", "worm").asJava
        suggester.suggest("wol") shouldBe List("wolf").asJava
      }
    }

    describe("187 english words dictionary") {
      val dictionary = Source.fromFile("src/main/resources/words.txt")
        .getLines().toList.map(_.trim).filter(_.nonEmpty).asJava
      val suggester = new TrieSuggestSearch
      suggester.loadDictionary(dictionary)

      it("should suggest words in the dictionary") {
        suggester.suggest("be") shouldBe List("be", "because", "been", "before", "below", "between").asJava
      }
    }
  }
}
