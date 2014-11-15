package com.castro.chapter8
//NOTE: problematic array length is 0
class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

//remedies:
// - declare the val as final (not flexible)
// - declare the val as lazy in the superclass (inefficient)
// - use early definition syntax, see below

class Bug extends {
  override val range = 3
} with Creature