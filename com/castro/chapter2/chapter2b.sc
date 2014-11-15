package com.castro.chapter2

import java.text.MessageFormat

object chapter2b {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val n = 5                                       //> n  : Int = 5
  var r = 0                                       //> r  : Int = 0
  for (i <- 1 to n) r = r * i
  
  //2.6 Advanced for Loops and for Comprehensions
  for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")
                                                  //> 11 12 13 21 22 23 31 32 33 
  //11 12 13 21 22 23 31 32 33
  
  //with a guard
  for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")
                                                  //> 12 13 21 23 31 32 
  //12 13 21 23 31 32
  
  for (i <- 1 to 3; from = 4 - i; j <- from to 3) print((10 * i + j) + " ")
                                                  //> 13 22 23 31 32 33 
  //13 22 23 31 32 33
  for (i <- 1 to 10) yield i % 3                  //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 0, 1, 2, 0, 
                                                  //| 1, 2, 0, 1)
  //yields Vector(1,2,0,1,2,0,1,2,0,1)
  //for comprehension
  
  for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
                                                  //> res1: String = HIeflmlmop
  //yields "HIeflmlmop"
  
  for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
                                                  //> res2: scala.collection.immutable.IndexedSeq[Char] = Vector(H, e, l, l, o, I,
                                                  //|  f, m, m, p)
  
  //2.7 Functions
  def fac(n: Int) = {
  	var r = 1
  	for (i <- 1 to n) r = r * i
  	r
  }                                               //> fac: (n: Int)Int
  fac(3)                                          //> res3: Int = 6
  
  //recursive
  def fac1(n: Int): Int = if (n <= 0) 1 else n * fac1(n -1)
                                                  //> fac1: (n: Int)Int
  fac1(3)                                         //> res4: Int = 6
  
  //2.8 Default and Named Arguments
  def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
                                                  //> decorate: (str: String, left: String, right: String)String
  decorate("Hello")                               //> res5: String = [Hello]
  decorate("Hello", "<<<", ">>>")                 //> res6: String = <<<Hello>>>
  decorate("Hello", ">>>[")                       //> res7: String = >>>[Hello]
  decorate(left="<<<", str="Hello", right=">>>")  //> res8: String = <<<Hello>>>
  decorate("Hello", right="]<<<")                 //> res9: String = [Hello]<<<
  
  //2.9 Variable Arguments
  def sum(args: Int*) = {
  	var result = 0
  	for (arg <- args) result += arg
  	result
  }                                               //> sum: (args: Int*)Int
  val s = sum(1,4,9,16,25)                        //> s  : Int = 55
  val s1 = sum(1 to 5: _*)                        //> s1  : Int = 15
  
  def recursiveSum(args: Int*): Int = {
  	if (args.length == 0) 0
  	else args.head + recursiveSum(args.tail: _*)
  }                                               //> recursiveSum: (args: Int*)Int
  
  //convert any primitive types by hand
  val str = MessageFormat.format("The answer to {0} is {1}", "everything", 42.asInstanceOf[AnyRef])
                                                  //> str  : String = The answer to everything is 42
                   
  //2.10 Procedures
  def box(s: String) {
  	val border = "-" * s.length + "--\n"
  	println(border + "|" + s + "|\n" + border)
  }                                               //> box: (s: String)Unit
  box("Hello")                                    //> -------
                                                  //| |Hello|
                                                  //| -------
                                                  //| 
  //2.11 Lazy Values
  lazy val words = scala.io.Source.fromFile("/usr/share/dict/words").mkString
                                                  //> words: => String
  //evaluated as soon as words is defined
  val words1 = scala.io.Source.fromFile("/usr/share/dict/words").mkString
                                                  //> words1  : String = "A
                                                  //| a
                                                  //| aa
                                                  //| aal
                                                  //| aalii
                                                  //| aam
                                                  //| Aani
                                                  //| aardvark
                                                  //| aardwolf
                                                  //| Aaron
                                                  //| Aaronic
                                                  //| Aaronical
                                                  //| Aaronite
                                                  //| Aaronitic
                                                  //| Aaru
                                                  //| Ab
                                                  //| aba
                                                  //| Ababdeh
                                                  //| Ababua
                                                  //| abac
                                                  //| abaca
                                                  //| abacate
                                                  //| abacay
                                                  //| abacinate
                                                  //| abacination
                                                  //| abaciscus
                                                  //| abacist
                                                  //| aback
                                                  //| abactinal
                                                  //| abactinally
                                                  //| abaction
                                                  //| abactor
                                                  //| abaculus
                                                  //| abacus
                                                  //| Abadite
                                                  //| abaff
                                                  //| abaft
                                                  //| abaisance
                                                  //| abaiser
                                                  //| abaissed
                                                  //| abalienate
                                                  //| abalienation
                                                  //| abalone
                                                  //| Abama
                                                  //| abampere
                                                  //| abandon
                                                  //| abandonable
                                                  //| abandoned
                                                  //| abandonedly
                                                  //| abandonee
                                                  //| abandoner
                                                  //| abandonment
                                                  //| Abanic
                                                  //| Abantes
                                                  //| abaptiston
                                                  //| Abarambo
                                                  //| Abaris
                                                  //| abarthrosis
                                                  //| abarticular
                                                  //| abarticulation
                                                  //| abas
                                                  //| abase
                                                  //| abased
                                                  //| abasedly
                                                  //| abasedness
                                                  //| abasement
                                                  //| abaser
                                                  //| Abasgi
                                                  //| abash
                                                  //| abashed
                                                  //| abashedly
                                                  //| abashedness
                                                  //| abashless
                                                  //| abashlessly
  //evaluated the first time words is used
  lazy val words2 = scala.io.Source.fromFile("/usr/share/dict/words").mkString
                                                  //> words2: => String
  //evaluated every time words is used
  def words3 = scala.io.Source.fromFile("/usr/share/dict/words").mkString
                                                  //> words3: => String
  
  //2.12 Exceptions
  val x = 1                                       //> x  : Int = 1
  if (x >= 0) { math.sqrt(x)
  } else throw new IllegalArgumentException("x should not be negative")
                                                  //> res10: Double = 1.0
  
  //Excercises
  //1
  def signum(x: Int) = {
  	if (x > 0) 1 else if (x == 0) 0 else -1
  }                                               //> signum: (x: Int)Int
  val x1 = signum(2)                              //> x1  : Int = 1
  val x2 = signum(0)                              //> x2  : Int = 0
  val x3 = signum(-2)                             //> x3  : Int = -1
  
  //2
  val abc = {}                                    //> abc  : Unit = ()
  
  for(i <- 1 to 10; x = 10 - i) println(x)        //> 9
                                                  //| 8
                                                  //| 7
                                                  //| 6
                                                  //| 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0
  def countdown(n: Int) {
  	
  }                                               //> countdown: (n: Int)Unit
  
}