package com.github.fedeoasi.intervals

import java.io.{BufferedReader, FileReader}
import java.util
import java.util.Date
import java.util.Map.Entry

import scala.collection.JavaConverters._

case class Interval(id: Int, a: Int, b: Int) extends Ordered[Interval] {
  def intersects(that: Interval): Boolean = {
    that.a >= a && that.a <= b ||
      that.b >= a && that.b <= b
  }

  import scala.math.Ordered.orderingToOrdered

  override def compare(that: Interval): Int = {
    (this.a, this.b).compare((that.a, that.b))
  }
}

class IntervalStrength(source: Seq[Interval], target: Seq[Interval]) {
  def computeSolution: Int = {
    val targetByA = target.groupBy(_.a)
    val targetByB = target.groupBy(_.b)

    val allKeys = (targetByA.keys ++ targetByB.keys ++ targetByB.keys.map(_ + 1)).toSeq.sorted

    println(s"${new Date()} - preprocessing")

    val intervalIdsByPosition: util.TreeMap[Int, Set[Int]] = {
      val _map = new util.TreeMap[Int, Set[Int]]()
      allKeys.foldLeft((Set.empty[Int], Set.empty[Int])) { case ((currentSet, toBeRemoved), key) =>
        var newSet = currentSet
        targetByA.get(key) match {
          case Some(startingIntervals) =>
            startingIntervals.foreach { i => newSet = newSet + i.id }
          case None =>
        }
        val newToBeRemoved = targetByB.get(key) match {
          case Some(endingIntervals) => endingIntervals.map(_.id).toSet
          case None => Set.empty[Int]
        }
        newSet = newSet -- toBeRemoved
        _map.put(key, newSet)
        (newSet, newToBeRemoved)
      }
      _map
    }

    println(s"${new Date()} - Computing solution")
    source.map { s =>
      val optionalLowerBound = Option(intervalIdsByPosition.floorEntry(s.a)).map(_.getKey)
      val optionalUpperBound = Option(intervalIdsByPosition.floorEntry(s.b)).map(_.getKey)

      optionalUpperBound match {
        case None => 0
        case Some(upperBound) =>
          val lowerBound = optionalLowerBound.getOrElse(intervalIdsByPosition.firstKey())
          val subMap = intervalIdsByPosition.subMap(lowerBound, true, upperBound, true)
          subMap.asScala.foldLeft(Set.empty[Int]) {
            case (acc, (_, set)) =>
              acc ++ set
          }.size
      }
    }.sum
  }

  def strengthFor(s: Interval): Int = {
    target.map { t =>
      if (s.intersects(t)) 1 else 0
    }.sum
  }
}

object Solution {
  def main(args: Array[String]) {
    val inputFile = "/home/fcaimi/Documents/hackerrank/x-and-his-shots/input03.txt"
//    solve(new BufferedReader(new InputStreamReader(System.in)))
    solve(new BufferedReader(new FileReader(inputFile)))
  }

  def solve(input: BufferedReader): Unit = {
    val Array(n, m) = input.readLine().split(" ").map(_.toInt)
    val target = Range(0, n).map { i =>
      val Array(a, b) = input.readLine().split(" ").map(_.toInt)
      Interval(i + 1, a, b)
    }
    val source = Range(0, m).map { i =>
      val Array(a, b) = input.readLine().split(" ").map(_.toInt)
      Interval(i + 1, a, b)
    }
    println(new IntervalStrength(source, target).computeSolution)
  }
}