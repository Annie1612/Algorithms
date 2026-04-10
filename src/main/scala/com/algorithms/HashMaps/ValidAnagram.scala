package com.algorithms.HashMaps

import scala.collection.mutable

object ValidAnagram extends App{

  def validAnagram(str1: String, str2: String): Boolean = {
    val strHashMap = mutable.HashMap.empty[Char, Int]
    if (str1.length == str2.length) {
      str1.foreach { st1Character =>
        strHashMap(st1Character) = strHashMap.getOrElse(st1Character, 0) +1
      }
      str2.foreach {
        str2Character =>
          if (strHashMap.getOrElse(str2Character, 0) == 0) return false
          strHashMap(str2Character) -1
      }
      true
    } else false
  }

  println(validAnagram("annie", "einna"))
}
