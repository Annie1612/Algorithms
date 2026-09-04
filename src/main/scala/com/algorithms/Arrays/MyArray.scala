package com.algorithms.Arrays;

import java.nio.ByteBuffer
object myArray extends App {
//Static Array
val myArrayExample = new myArray(5);
myArrayExample.set(0, 10);
println(myArrayExample.get(0))
println(myArrayExample.get(2))

//DynamicArray
val dynamicArray = new myDynamicArray(initialCapacity=3)
dynamicArray.push(10) 
dynamicArray.push(20)
dynamicArray.push(30)
dynamicArray.push(40)
dynamicArray.push(50)
println(s"Dynamic array at index 0 is ${dynamicArray.get(0)}") 
println(s"Dynamic array at index 4 is ${dynamicArray.get(4)}") //resized and size grown
println(s"Dynamic Array length is ${dynamicArray.length}")
//checking if the resized array can be reqritten using set
dynamicArray.set(4,55)
println(s"Dynamic array setting at index 5 is ${dynamicArray.get(4)}")

//testing pop!!

println(s"Dynamic array for pop is ${dynamicArray.pop()}")
}

class myArray(val length: Int) {
  val elementSize = 4 //because of Int
  val memoryAllocated: ByteBuffer = ByteBuffer.allocateDirect(length *elementSize)

  def get(index: Int) : Int = {
   require(index >=0 && index < length, s"Index $index out of bounds")
    memoryAllocated.getInt(index*elementSize)
  }

  def set(index:Int, value: Int): Unit = { 
   require(index>=0 && index < length, s"Index $index out of bound")
   memoryAllocated.putInt(index*elementSize, value)
  }
}


class myDynamicArray(initialCapacity: Int=4){
 val elementSize = 4 //Int
 var capacity = initialCapacity
 var memoryAllocated : ByteBuffer = ByteBuffer.allocateDirect(elementSize * capacity)
 var size = 0

 def length = size

  def get(index: Int): Int = {
    require(index >=0 && index < size, s"index get in dynamic $index out of bounds")
    memoryAllocated.getInt(index* elementSize)
  }

  def set(index: Int, value: Int): Unit = { //for existing elements you can overwrite
   require(index >=0 && index < size, s"Index set in dynamic $index out of bounds")
   memoryAllocated.putInt(index* elementSize, value)
  }

  def push(item: Int): Unit = {
   if (size == capacity) grow()
   
   memoryAllocated.putInt(size * elementSize, item)
   size += 1
  }

  def grow(): Unit = {
  //double the size
  val newCapacity = capacity * 2
  val newMemoryAllocated: ByteBuffer = ByteBuffer.allocateDirect(newCapacity * elementSize)

  //copy data to new array
   for (i <- 0 until size) {
     newMemoryAllocated.putInt(i*elementSize, memoryAllocated.getInt(i * elementSize))
   }
   
  memoryAllocated = newMemoryAllocated
  capacity = newCapacity
  }

  def pop(): Int = {
   require(size > 0, "Array empty")
   val lastItem = memoryAllocated.getInt((size-1)*elementSize)
   size -=1
   lastItem
  }

}
