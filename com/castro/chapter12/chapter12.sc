package com.castro.chapter12

import javax.swing.JButton
import java.awt.event.ActionListener
import java.awt.event.ActionEvent


object chapter12 {
  println("Chapter 12 - Higher-Order Functions")  //> Chapter 12 - Higher-Order Functions
  
  //12.1 Functions as Values
  import scala.math._
  val num = 3.14                                  //> num  : Double = 3.14
  val fun = ceil _                                //> fun  : Double => Double = <function1>
  fun(num)                                        //> res0: Double = 4.0
  
  Array(3.14, 1.42, 2.0).map(fun)                 //> res1: Array[Double] = Array(4.0, 2.0, 2.0)
  
  //12.2 Anonymous Functions
  (x: Double) => 3 * x                            //> res2: Double => Double = <function1>
  val triple = (x: Double) => 3 * x               //> triple  : Double => Double = <function1>
  
  def triple_1(x: Double) = 3 * x                 //> triple_1: (x: Double)Double
  Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)//> res3: Array[Double] = Array(9.42, 4.26, 6.0)
  
  Array(3.14, 1.42, 2.0).map{ (x:Double) => 3 * x }
                                                  //> res4: Array[Double] = Array(9.42, 4.26, 6.0)
  Array(3.14, 1.42, 2.0) map { (x:Double) => 3 * x }
                                                  //> res5: Array[Double] = Array(9.42, 4.26, 6.0)
  //12.3 Functions with Function Parameters
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
                                                  //> valueAtOneQuarter: (f: Double => Double)Double
  valueAtOneQuarter(ceil _)                       //> res6: Double = 1.0
  valueAtOneQuarter(sqrt _)                       //> res7: Double = 0.5
  
  def mulBy(factor: Double) = (x: Double) => factor * x
                                                  //> mulBy: (factor: Double)Double => Double
  mulBy(3)                                        //> res8: Double => Double = <function1>
  val quintuple = mulBy(5)                        //> quintuple  : Double => Double = <function1>
  quintuple(20)                                   //> res9: Double = 100.0
  
  //12.4 Parameter Inference
  valueAtOneQuarter((x: Double) => 3 * x)         //> res10: Double = 0.75
  valueAtOneQuarter((x) => 3 * x)                 //> res11: Double = 0.75
  valueAtOneQuarter(x => 3 * x)                   //> res12: Double = 0.75
  valueAtOneQuarter(3 * _)                        //> res13: Double = 0.75
  
  //val fun = 3 * _
  val fun1 = 3 * (_: Double)                      //> fun1  : Double => Double = <function1>
  val fun2: (Double) => Double = 3 * _            //> fun2  : Double => Double = <function1>
  
  //12.5 Useful Higher-Order Functions
  (1 to 9).map(0.1 * _)                           //> res14: scala.collection.immutable.IndexedSeq[Double] = Vector(0.1, 0.2, 0.3
                                                  //| 0000000000000004, 0.4, 0.5, 0.6000000000000001, 0.7000000000000001, 0.8, 0.
                                                  //| 9)
  
  (1 to 9).map("*" * _).foreach(println _)        //> *
                                                  //| **
                                                  //| ***
                                                  //| ****
                                                  //| *****
                                                  //| ******
                                                  //| *******
                                                  //| ********
                                                  //| *********
  (1 to 9).filter(_ % 2 == 0)                     //> res15: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8)
  (1 to 9).reduceLeft(_ * _)                      //> res16: Int = 362880
  "Mary had a little lamb".split(" ").sortWith(_.length < _.length)
                                                  //> res17: Array[String] = Array(a, had, Mary, lamb, little)
  //12.6 Closures
  def multiplyBy(factor: Double) = (x: Double) => factor * x
                                                  //> multiplyBy: (factor: Double)Double => Double
  val triple1 = multiplyBy(3)                     //> triple1  : Double => Double = <function1>
  val half = multiplyBy(0.5)                      //> half  : Double => Double = <function1>
  println(triple1(14) + " " + half(14))           //> 42.0 7.0
  
  //12.7 SAM (single abstract method) Conversions
  var counter = 0                                 //> counter  : Int = 0
  val button = new JButton("Increment")           //> button  : javax.swing.JButton = javax.swing.JButton[,0,0,0x0,invalid,alignm
                                                  //| entX=0.0,alignmentY=0.5,border=com.apple.laf.AquaButtonBorder$Dynamic@43350
                                                  //| d11,flags=288,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disable
                                                  //| dIcon=,disabledSelectedIcon=,margin=javax.swing.plaf.InsetsUIResource[top=0
                                                  //| ,left=2,bottom=0,right=2],paintBorder=true,paintFocus=true,pressedIcon=,rol
                                                  //| loverEnabled=false,rolloverIcon=,rolloverSelectedIcon=,selectedIcon=,text=I
                                                  //| ncrement,defaultCapable=true]
  /*
  button.addActionListener(new ActionListener {
  	override def actionPerformed(event: ActionEvent) {
  		counter += 1
  	}
  })
  */
  implicit def makeAction(action: (ActionEvent) => Unit) = new ActionListener {
  	override def actionPerformed(event: ActionEvent) { action(event) }
  }                                               //> makeAction: (action: java.awt.event.ActionEvent => Unit)java.awt.event.Acti
                                                  //| onListener
  button.addActionListener((event: ActionEvent) => counter += 1)
  
  //12.8 Currying - named after logician Haskell Brooks Curry
  def mul(x: Int, y: Int) = x * y                 //> mul: (x: Int, y: Int)Int
  def mulOneAtATime(x: Int) = (y: Int) => x * y   //> mulOneAtATime: (x: Int)Int => Int
  mulOneAtATime(6)(7)                             //> res18: Int = 42
  //shortcut
  def mulOneAtATime_1(x: Int)(y: Int) = x * y     //> mulOneAtATime_1: (x: Int)(y: Int)Int
  
  val a = Array("Hello", "World")                 //> a  : Array[String] = Array(Hello, World)
  val b = Array("hello", "world")                 //> b  : Array[String] = Array(hello, world)
  a.corresponds(b)(_.equalsIgnoreCase(_))         //> res19: Boolean = true
  
  //12.9 Control Abstractions
  def runInThread(block: => Unit) {
  	new Thread {
  		override def run() { block }
  	}.start()
  }                                               //> runInThread: (block: => Unit)Unit
  
  //runInThread { () => println("Hi"); Thread.sleep(10000); println("Bye") }
  runInThread { println("Hi"); Thread.sleep(100); println("Bye") }
  
  def until(condition: => Boolean)(block: => Unit) {
  	if(!condition) {
  		block
  		until(condition)(block)
  	}
  }                                               //> until: (condition: => Boolean)(block: => Unit)Unit
  
  var x = 10                                      //> Hi
                                                  //| x  : Int = 10
  until (x == 0) {
  	x -= 1
  	println(x)
  }                                               //> 9
                                                  //| 8
                                                  //| 7
                                                  //| 6
                                                  //| 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0
  
  //12.10 The return Expression
  def indexOf(str: String, ch: Char): Int = {
  	var i = 0
  	until (i == str.length) {
  		if(str(i) == ch) return i
  		i += 1
  	}
  	return -1
  }                                               //> indexOf: (str: String, ch: Char)Int-
}