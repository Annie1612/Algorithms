package com.algorithms.HashMaps

import scala.collection.mutable

/*
find the common elements between two arrays.
 */
object IntersectionTwoArrays extends App {
  def intersectionTwoArrays(num1: Array[Int], num2: Array[Int]): Set[Int] = {
    var result = Set.empty[Int]
    val numHashMap = mutable.HashMap.empty[Int, Int]
    for (num <- num1) {
      if (!numHashMap.contains(num)) numHashMap.put(num, 1)
    }
    for (num <- num2) {
      if (numHashMap.contains(num)) result = result + num
    }
    result
  }

  println(intersectionTwoArrays(Array(1, 2, 3, 4, 1), Array(2, 3, 4, 1, 5, 6)))

}
