package com.algorithms.HashMaps

import scala.collection.mutable

object ContainsDuplicates extends App {
  /*
  Given an integer array nums, return true
  if any value appears at least twice in the array,
  and false if every element is distinct
   */

  def containsDuplicate(nums: Array[Int]): Boolean = {
    val numsHashMap = mutable.HashSet[Int]()
    var flag=false
    nums.map { num =>
      if (numsHashMap.contains(num)) flag=true
      numsHashMap.add(num)
    }
    flag
  }

  println(containsDuplicate(Array(1,2,1,4)))
}
