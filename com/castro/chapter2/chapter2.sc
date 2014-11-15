package com.castro.chapter2

object chapter2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //2.1 Conditional Expressions
  val xyz = 2                                     //> xyz  : Int = 2
  var s = if(xyz > 0) 1 else -1                   //> s  : Int = 1
  if (xyz > 0) s = 1 else s = -1
  if (xyz > 0) "positive" else -1                 //> res0: Any = positive
  if (xyz > 0) 1 else ()                          //> res1: AnyVal = 1
  if (xyz < 0) 1                                  //> res2: AnyVal = ()
  if (xyz < 0) 1 else ()                          //> res3: AnyVal = ()
  
  //2.2 Statement Termination
  var n = 2                                       //> n  : Int = 2
  var r = 1                                       //> r  : Int = 1
  if (n > 0) { r = r * n; n -= 1 }
  var s0, v, v0, t, a, a0 = 1                     //> s0  : Int = 1
                                                  //| v  : Int = 1
                                                  //| v0  : Int = 1
                                                  //| t  : Int = 1
                                                  //| a  : Int = 1
                                                  //| a0  : Int = 1
  var sp = s0 + (v - v0) * t +	0.5 * (a - a0) * t * t
                                                  //> sp  : Double = 1.0
  if (n > 0) {
  	r = r * n
  	n -= 1
  }
  
  //2.3 Block Expressions and Assignments
  import scala.math._
  val x, y = 4                                    //> x  : Int = 4
                                                  //| y  : Int = 4
  val x0, y0 = 2                                  //> x0  : Int = 2
                                                  //| y0  : Int = 2
  val distance = {
  	val dx = x - x0
  	val dy = y - y0
  	sqrt(dx * dx + dy * dy)
  }                                               //> distance  : Double = 2.8284271247461903
  
  { r = r * n; n -= 1}
  
  //2.4 Input and Output
  print("Answer: ")                               //> Answer: 
  println(42)                                     //> 42
 	printf("Hello, %s! You are %d years old.\n", "Glenn", 24)
                                                  //> Hello, Glenn! You are 24 years old.
 
 //val name = readLine("Your name: ")
 //print("Your age: ")
 //val age = readInt()
 //printf("Hello, %s!  Next year, you will be %d. \n", name, age + 1)
 
 
 //2.5 Loops
 while (n > 0) {
 	r = r * n
 	n -= 1
 }
 
 for (i <- 1 to n) r = r + i
 
 val str = "Hello"                                //> str  : String = Hello
 var sum = 0                                      //> sum  : Int = 0
 for (i <- 0 until str.length) sum += str(i)
 for (ch <- "Hello") sum += ch
 
}