package com.algorithms.HashMaps

import scala.collection.mutable

/*
The Contains Duplicate II problem asks to determine if an integer array (nums) contains two distinct indices
 and
 such that nums[i] == nums[j] and the absolute difference between them is at most k
. It returns true if this condition is met, and false otherwise

1. nums = [1,2,3,1], k = 3
   True (1 is at 0 and 3,0-3 <= 3
2. nums = [1,2,2,1,2,3], k = 2
   False (1s are 3 apart)

).
 */
object ContainsDuplicatesII extends App {

  def isDuplicateIndices(nums: Array[Int], sum: Int): Boolean = {
    val numHashMap = mutable.HashMap.empty[Int, Int]
    nums.zipWithIndex.foreach {
      case (num, index) => if (numHashMap.contains(num)) {
        if ((index + (numHashMap(num))) <= sum)
          return true
      }
      else {
        numHashMap.put(num, index)
      }
    }
    false
  }

  println(isDuplicateIndices(Array(1, 2, 2, 5, 2, 3), 3))
}
