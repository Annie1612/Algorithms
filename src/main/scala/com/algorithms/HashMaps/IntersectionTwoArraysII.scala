package com.algorithms.HashMaps

import scala.collection.mutable

/*
find the intersection of two arrays maintaining the duplicates/frequency.
 */
object IntersectionTwoArraysII extends App {

  def intersectionTwoArrays(num1: Array[Int], num2: Array[Int]): List[Int] = {
    var result = Array.empty[Int]
    val numHashMap = mutable.HashMap.empty[Int, Int]
    for (num <- num1) {
      numHashMap(num) = numHashMap.getOrElse(num, 0) + 1
    }
    for (num <- num2) {
      if (numHashMap.contains(num) && numHashMap(num) != 0) {
        result = result :+ num
        numHashMap.put(num, numHashMap(num) - 1)
      }
    }
    result.toList
  }

  println(intersectionTwoArrays(Array(4, 9, 5), Array(9, 4, 9, 8, 4)))
}
