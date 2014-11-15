package com.castro.chapter1

object chapter1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val res0 = 8 * 5 + 2                            //> res0  : Int = 42
  0.5 * res0                                      //> res0: Double = 21.0
  "Hello " + res0                                 //> res1: String = Hello 42
  var ans = 1                                     //> ans  : Int = 1
  ans = 2
  ans                                             //> res2: Int = 2
  val greeting1: String = null                    //> greeting1  : String = null
  val greeting2: Any = "Hello"                    //> greeting2  : Any = Hello
  val xmax, ymax = 100                            //> xmax  : Int = 100
                                                  //| ymax  : Int = 100
  var greeting, message: String = null            //> greeting  : String = null
                                                  //| message  : String = null
 //1.3 Commonly Used Types
  1.toString                                      //> res3: String = 1
  1.to(10)                                        //> res4: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10)
 "Hello".intersect("World")                       //> res5: String = lo
 99.44.toInt                                      //> res6: Int = 99
 99.toChar                                        //> res7: Char = c
 "99.44".toDouble                                 //> res8: Double = 99.44
 
 //1.4 Arithmetic and Operator Overloading
 val answer = 8 * 5 + 2                           //> answer  : Int = 42
 val a = 2                                        //> a  : Int = 2
 val b = 3                                        //> b  : Int = 3
 val c = a + b                                    //> c  : Int = 5
 val d = a.+(b)                                   //> d  : Int = 5
 1 to 5                                           //> res9: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
 var counter = 0                                  //> counter  : Int = 0
 counter += 1
 val x: BigInt = 1234567890                       //> x  : BigInt = 1234567890
 x * x * x                                        //> res10: scala.math.BigInt = 1881676371789154860897069000
 
 //1.5 Calling Functions and Methods
 import math._
 sqrt(2)                                          //> res11: Double = 1.4142135623730951
 pow(2, 4)                                        //> res12: Double = 16.0
 min(3, Pi)                                       //> res13: Double = 3.0
 Pi                                               //> res14: Double = 3.141592653589793
 BigInt.probablePrime(10, scala.util.Random)      //> res15: scala.math.BigInt = 691
 "Hello".distinct                                 //> res16: String = Helo
 
 //1.6 The apply Method
 "Hello"(4)                                       //> res17: Char = o
 //def apply(n: Int): Char
 "Hello".apply(4)                                 //> res18: Char = o
 BigInt("1234567890")                             //> res19: scala.math.BigInt = 1234567890
 BigInt.apply("1234567890")                       //> res20: scala.math.BigInt = 1234567890
 BigInt("1234567890") * BigInt("112358111321")    //> res21: scala.math.BigInt = 138713716417952082690
 Array(1,4,9,16)                                  //> res22: Array[Int] = Array(1, 4, 9, 16)
 
 //Exercises
 val sq1 = sqrt(3)                                //> sq1  : Double = 1.7320508075688772
 pow(sq1, 2)                                      //> res23: Double = 2.9999999999999996
 
 "crazy" * 3                                      //> res24: String = crazycrazycrazy
 "crazy" + 3                                      //> res25: String = crazy3
 
 10 max 2                                         //> res26: Int = 10
 //using BigInt??? 2 to the 1024 power
 pow(2, 1024)                                     //> res27: Double = Infinity

"Scala"(0)                                        //> res28: Char = S
"Scala".last                                      //> res29: Char = a
 
 "abcde".take(2)                                  //> res30: String = ab
 "abcde".drop(3)                                  //> res31: String = de
 "abcde".takeRight(4)                             //> res32: String = bcde
 "abcde".dropRight(1)                             //> res33: String = abcd
 "abcde".substring(2)                             //> res34: String = cde
}