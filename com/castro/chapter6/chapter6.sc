package com.castro.chapter6

object chapter6 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //6.1 Singletons
  Account.newUniqueNumber()                       //> res0: Int = 1
  
  //6.2 Companion Objects
  val savingsAccount = new Account                //> savingsAccount  : com.castro.chapter6.Account = com.castro.chapter6.Account@
                                                  //| 18ff8acd
  savingsAccount.deposit(30000)
  savingsAccount.currentBalance                   //> res1: Double = 30000.0
  savingsAccount.deposit(5000)
  savingsAccount.currentBalance                   //> res2: Double = 35000.0
  
  //6.3 Objects Extending a Class or Trait
  val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)
                                                  //> actions  : scala.collection.immutable.Map[String,com.castro.chapter6.DoNothi
                                                  //| ngAction.type] = Map(open -> com.castro.chapter6.DoNothingAction$@76115ae0, 
                                                  //| save -> com.castro.chapter6.DoNothingAction$@76115ae0)
  
  //6.4 The apply Method
  // Array(100) calls the apply(100), yielding an Array[Int] with a single element, the integer 100
  // new Array(100) invokes this(100), the result is Array[Nothing] with 100 null elements
  Array("Mary", "had", "a", "little", "lamb")     //> res3: Array[String] = Array(Mary, had, a, little, lamb)
  Array(Array(1,7), Array(2,9))                   //> res4: Array[Array[Int]] = Array(Array(1, 7), Array(2, 9))
  
  val acct = AccountApply(1000.0)                 //> acct  : com.castro.chapter6.AccountApply = com.castro.chapter6.AccountApply@
                                                  //| 7cf56489
  acct.currentBalance                             //> res5: Double = 1000.0
  acct.deposit(500.0)
  acct.currentBalance                             //> res6: Double = 1500.0
  
  //6.5 Application Objects
  
  //6.6 Enumerations
  TrafficLightColor.Green                         //> res7: com.castro.chapter6.TrafficLightColor.Value = Go
  TrafficLightColor.Yellow                        //> res8: com.castro.chapter6.TrafficLightColor.Value = Yellow
  TrafficLightColor.Red                           //> res9: com.castro.chapter6.TrafficLightColor.Value = Stop
  
  import TrafficLightColor._
  def doWhat(color: TrafficLightColor) = {
  	if (color == Red) "stop"
  	else if (color == Yellow) "hurry up"
  	else "go"
  }                                               //> doWhat: (color: com.castro.chapter6.TrafficLightColor.TrafficLightColor)Str
                                                  //| ing
  doWhat(Red)                                     //> res10: String = stop
  doWhat(Yellow)                                  //> res11: String = hurry up
  doWhat(Green)                                   //> res12: String = go
  
  for (c <- TrafficLightColor.values) println(c.id + ": " + c)
                                                  //> 0: Stop
                                                  //| 10: Yellow
                                                  //| 11: Go
  TrafficLightColor(0)                            //> res13: com.castro.chapter6.TrafficLightColor.Value = Stop
  TrafficLightColor(10)                           //> res14: com.castro.chapter6.TrafficLightColor.Value = Yellow
  TrafficLightColor.withName("Go")                //> res15: com.castro.chapter6.TrafficLightColor.Value = Go
}