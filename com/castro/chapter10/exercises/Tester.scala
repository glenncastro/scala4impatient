package com.castro.chapter10.exercises

object Tester extends App {
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.translate(10, -10)
  egg.grow(10, 20)
  
  val ant = new Ant
  println(ant.range)
  println(ant.env.length)
}

class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends {
   override val range = 2
} with Creature