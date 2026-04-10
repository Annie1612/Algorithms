package com.algorithms.HashMaps

import scala.collection.mutable

/*
Given an array of strings strs, the goal is to return a list of lists,
where each inner list contains strings that are anagrams.

Example Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Example Output: [["bat"], ["nat", "tan"], ["eat", "tea", "ate"]] (order may vary)
 */

// Answer sort the word by its characters and use that as the key
object GroupAnagram extends App {

  def groupAnagrams(anagramList: List[String]): List[List[String]] = {
    val lengthHashMap = mutable.HashMap.empty[String, List[String]]
    for (word <- anagramList) {
      val key = word.sorted
      lengthHashMap(key) = word :: lengthHashMap.getOrElse(key, Nil)
    }
    lengthHashMap.values.toList
  }

  println(groupAnagrams(List("eat", "tea", "tan", "ate", "nat", "bat")))

}
