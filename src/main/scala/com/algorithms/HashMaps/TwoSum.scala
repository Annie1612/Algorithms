package com.algorithms.HashMaps

import scala.collection.mutable

object TwoSum extends App {
//TwoSum
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val numsHashMap = mutable.HashMap.empty[Int, Int]
    var result = Array.empty[Int]
    nums.zipWithIndex.map {
      case (num, index) => {
        if(numsHashMap.contains(target-num)) {
          result = Array(numsHashMap(target-num), index)
        }
        else numsHashMap.put(num, index)
      }
    }
    result
  }

  println(twoSum(Array(2,5,7,11), 9).toList)
}
