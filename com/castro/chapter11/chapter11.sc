package com.castro.chapter11

object chapter11 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val √ = scala.math.sqrt _                       //> √  : Double => Double = <function1>
  √(4)                                            //> res0: Double = 2.0
  
  val π = scala.math.Pi                           //> π  : Double = 3.141592653589793
  π                                               //> res1: Double = 3.141592653589793
  
  //val `val` = 42
  Thread.`yield`()
  
  //Infix Operators
  1 to 10                                         //> res2: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10)
  1.to(10)                                        //> res3: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10)
  1 -> 10                                         //> res4: (Int, Int) = (1,10)
  1 .->(10)                                       //> res5: (Int, Int) = (1,10)
  
  val a = new Fraction(1,2)                       //> a  : com.castro.chapter11.Fraction = com.castro.chapter11.Fraction@53f9937
  val b = new Fraction(1,4)                       //> b  : com.castro.chapter11.Fraction = com.castro.chapter11.Fraction@1263ec92
  
  a *(b)                                          //> res6: com.castro.chapter11.Fraction = com.castro.chapter11.Fraction@5e406eac
                                                  //| 
  val c = 3                                       //> c  : Int = 3
  c.unary_-                                       //> res7: Int = -3
  
  3 + 4 -> 5                                      //> res8: (Int, Int) = (7,5)
  //3 -> 4 + 5
  3 -> 4                                          //> res9: (Int, Int) = (3,4)
  
  //right-associative :: operator for constructing list
  1 :: 2 :: Nil                                   //> res10: List[Int] = List(1, 2)
  
  val result = Fraction(3,4) * Fraction(2,5)      //> result  : com.castro.chapter11.Fraction = com.castro.chapter11.Fraction@106a
                                                  //| c42f
  val scores = new scala.collection.mutable.HashMap[String, Int]
                                                  //> scores  : scala.collection.mutable.HashMap[String,Int] = Map()
  // Calls scores.update("Bob", 100)
  scores("Bob") = 100
  
  // Calls scores.apply("Bob")
  val bobsScore = scores("Bob")                   //> bobsScore  : Int = 100
  
  val author = "Glenn Castro"                     //> author  : String = Glenn Castro
  // Calls Name.unapply(author)
  val Name(first, last) = author                  //> first  : String = Glenn
                                                  //| last  : String = Castro
  
  case class Currency(value: Double, unit: String)
  Currency(29.95, "EUR")                          //> res11: com.castro.chapter11.chapter11.Currency = Currency(29.95,EUR)
  //case Currency(amount, "USD") => println("$" + amount)
 
}