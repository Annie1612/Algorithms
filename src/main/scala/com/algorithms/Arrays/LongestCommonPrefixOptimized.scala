package com.algorithms.Arrays

object LongestCommonPrefixOptimized extends App {

  def longestCommonPrefixOptimized(str: Array[String]): String = {
    val firstWord = str(0)
    var firstLength = firstWord.length
    var flag = true
    for (word <- str.tail) {
      var i = 0
        if (flag) {
          while( i < firstLength && i < word.length && (firstWord(i) == word(i))) {
            i += 1
          }
        }
      firstLength = i
      if (firstLength == 0) flag = false
    }
    if(flag) firstWord.substring(0, firstLength) else ""
  }

  println(longestCommonPrefixOptimized(Array("flower","flow","flight")))

}
