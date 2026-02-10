package com.algorithms.Strings

import scala.collection.mutable

object ValidParanthesesOptimized extends App {

  def isValid(s: String): Boolean = {
    var stackBracket: mutable.Stack[Char] = mutable.Stack.empty
    var flag = true
    if (s.isEmpty) false else {
      s.map {
        case c  if (c == '(' || c == '{' || c =='[') => stackBracket.push(c)
        case ')' => if (stackBracket.headOption.contains('(')) stackBracket.pop() else flag = false
        case '}' => if (stackBracket.headOption.contains('{')) stackBracket.pop() else flag = false
        case ']' => if (stackBracket.headOption.contains('[')) stackBracket.pop() else flag = false
        case _ => throw new IllegalArgumentException ("Invalid character")
      }
      if (stackBracket.nonEmpty || !flag) false else true
    }
  }

  println(isValid(s"[]"))
  println(isValid(s"{[]}"))
  println(isValid(s"{[[}"))
  println(isValid(s"}}]"))
  println(isValid(s""))
  println(isValid(s")(){}"))
  println(isValid(s"([)"))
}
