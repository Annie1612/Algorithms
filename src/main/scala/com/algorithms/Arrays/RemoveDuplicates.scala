package com.algorithms.Arrays

object RemoveDuplicates extends App {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else {
      var i = 0;
      for( j<- 1 until nums.length) {
        if (nums(j) != nums(i)) {
          i = i+1
          nums(i) = nums(j)
        }
      }
      nums.foreach(println(_))
      i+1
    }
  }

  println(s"k is ${removeDuplicates(Array(0,0,1,1,1,2,2,3,3,4))}")

}
