
package com.algorithms

import scala.collection.mutable.HashMap

object TwoSumOptimized extends App{
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    //using hashMaps O(1)
    var sampleHashMap = HashMap.empty[Int, Int]
    nums.zipWithIndex.foreach {
      case (key, index) =>  {
        var complement = target - key
        if (sampleHashMap.contains(complement)) {
          return Array(sampleHashMap(complement), index)
        } else
          sampleHashMap.put(key, index)
      }
    }
    return Array.empty[Int]
  }

  //time complexity is O(n)
  println(twoSum(Array(2,7,11,15,18), 9).toList)
}