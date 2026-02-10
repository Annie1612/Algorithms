package com.algorithms

object PalindromOptimzed extends App {
//Runtime 5ms - time complexity logn
  def isPalindrome(x: Int) : Boolean = {
    if (x < 10 && x >= 0) true
    else if (x < 0) false
    else {
      checkPalindrome(x / 10, x % 10) == x
    }
  }

  def checkPalindrome(divisor: Int, remainder: Int): Int = {
    if (divisor >= 10) {
      checkPalindrome(divisor/10, (remainder *10) + (divisor%10))
    }
    else {
      remainder*10 + divisor
    }
  }

}
