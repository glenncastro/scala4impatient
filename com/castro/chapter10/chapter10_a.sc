package com.castro.chapter10

import scala.util.logging.Logged

object chapter10_a {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  class SavingsAccount extends Account with Logged {
  	def withdraw(amount: Double) {
  		if(amount > balance) log("Insufficient funds")
  	}
  }
  
  val s = new SavingsAccount                      //> s  : com.castro.chapter10.chapter10_a.SavingsAccount = com.castro.chapter10.
                                                  //| chapter10_a$$anonfun$main$1$SavingsAccount$1@ebe9f73
  s.balance = 10
  s.withdraw(100)
  
}