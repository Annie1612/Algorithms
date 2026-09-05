/*
Container with Most water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Constraints?
2. what happens when the array only has 1 value? what should we return then? RETURN 0
3. what if the array is empty? - RETIRN 0
4. the thickness take up space in the container? - no
5. do the left and the right sides count as walls?
6. Does a higher line affect our area? - no


//test cases
Array(7,1,2,3,9) o/p - 28
Array() - o/p 0
Array(1) - o/p 0
Array(6,9,10,3,1,8) o/p - 32 (8*4)
*/

package com.algorithms.Arrays

object ContainerWater extends App {
  def getContainerOptimized(height: Array[Int]): Int = {
    var maxNumber = 0
    var maxHeight = 0
    var i = 0
    var j = height.length - 1
    while (i < j) {
      if (height(i) <= height(j)) {
        if (maxHeight < height(i)) {
          var area = height(i) * (j - i)
          if (maxNumber < area) {
            maxHeight = height(i)
            maxNumber = area
          }
        }
        i = i + 1
      }
      else {
        if (maxHeight < height(j)) {
          var area = height(j) * (j - i)
          if (maxNumber < area) {
            maxHeight = height(j)
            maxNumber = area
          }
        }
        j = j - 1
      }
    }
    maxNumber
  }

  println(getContainerOptimized(Array(1,8,6,2,5,4,8,3,7)))
  println(getContainerOptimized(Array(7,1,2,3,9)))
  println(getContainerOptimized(Array(1)))
  println(getContainerOptimized(Array(6,9,10,3,1,8)))
}