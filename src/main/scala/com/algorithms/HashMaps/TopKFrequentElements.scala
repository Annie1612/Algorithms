package com.algorithms.HashMaps

import scala.collection.mutable

/*
Given a non-empty array of integers nums and an integer k, return the k most frequent elements.
The order of the output doesn't matter, and the time complexity should be better than O(n log n)
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1, 2] (or [2, 1])
 */
object TopKFrequentElements extends App {

  def topKFrequentElements(nums: Array[Int], k: Int): Array[Int] = {
    val numsHashMap = mutable.HashMap.empty[Int, Int]
    nums.foreach { num =>
      numsHashMap(num) =
        numsHashMap.getOrElse(num, 0)+1
    }
    numsHashMap.toList.sortBy(_._2).reverse.take(k).map(_._1).toArray
  }

  println(topKFrequentElements(Array(1,1,1,2,2,3), 2))
}
