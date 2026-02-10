package com.algorithms.Arrays

object ArraySubsetsOptimized extends App {

  def findSum(nums: Array[Int]) : Boolean = {
    if (nums.length < 2) return false
    val sortedArray = nums.sorted.reverse
    val largestElement = sortedArray(0)

    val remainigElements = sortedArray.tail
    var possibleSets = Set(0)

    for (i <- remainigElements) {
      possibleSets = possibleSets ++ possibleSets.map(_ + i)
      if (possibleSets.contains(largestElement)) return true
    }
    possibleSets.contains(largestElement)
  }

  println(findSum(Array(0, 4, 6, 3, 9, 12, 11)))

}
