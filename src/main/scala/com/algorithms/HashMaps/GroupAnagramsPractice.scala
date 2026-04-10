package com.algorithms.HashMaps

import scala.collection.mutable

object GroupAnagramsPractice extends App {
  def groupAnagrams(anagramList: List[String]): List[List[String]] = {
    val count = mutable.HashMap.empty[String, List[String]]
    for (word <- anagramList) {
     val key =  word.sorted
      count(key) = word :: count.getOrElse(word, Nil)
    }
    count.values.toList
  }

}
