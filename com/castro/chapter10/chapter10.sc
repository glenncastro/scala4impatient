package com.castro.chapter10

import scala.util.logging.Logged

object chapter10 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	
	//Chapter 10 - Traits
	//10.1 Why No Multiple Inheritance?
	//10.2 Traits as Interfaces
	
	//10.3 Traits with Concrete Implementations
	trait ConsoleLogger01 {
		def log(msg: String) { print(msg) }
	}
	
	//10.4 Objects with Traits
	class SavingsAccount1 extends Account with Logged {
		def withdraw(amount: Double) {
			if(amount > balance) log("Insufficient funds")
		}
	}
	
	trait ConsoleLogger extends Logged {
		override def log(msg: String) { println(msg) }
	}
	
	val acct = new SavingsAccount1 with ConsoleLogger
                                                  //> acct  : com.castro.chapter10.chapter10.SavingsAccount1 with com.castro.chapt
                                                  //| er10.chapter10.ConsoleLogger = com.castro.chapter10.chapter10$$anonfun$main$
                                                  //| 1$$anon$3@5675d86b
	
	//10.5 Layered Traits
	val acct1 = new SavingsAccount1 with ConsoleLogger with TimestampLogger with ShortLogger
                                                  //> acct1  : com.castro.chapter10.chapter10.SavingsAccount1 with com.castro.chap
                                                  //| ter10.chapter10.ConsoleLogger with com.castro.chapter10.TimestampLogger with
                                                  //|  com.castro.chapter10.ShortLogger = com.castro.chapter10.chapter10$$anonfun$
                                                  //| main$1$$anon$1@428643e3
	val acct2 = new SavingsAccount1 with ConsoleLogger with ShortLogger with TimestampLogger
                                                  //> acct2  : com.castro.chapter10.chapter10.SavingsAccount1 with com.castro.chap
                                                  //| ter10.chapter10.ConsoleLogger with com.castro.chapter10.ShortLogger with com
                                                  //| .castro.chapter10.TimestampLogger = com.castro.chapter10.chapter10$$anonfun$
                                                  //| main$1$$anon$2@449764b
	
	//10.6 Overriding Abstract Methods in Traits
	//abstrat override def log(msg: String) { super.log (msg) }
	
	//10.7 Traits for Rich Interfaces
	
	//10.8 Concrete Fields in Traits
	// Fields are added to the subclasses, not inherited
	
	//10.9 Abstract Fields in Traits

	//10.10 Trait Construction Order
	// - The superclass constructor is called first.
	// - Trait constructors are executed after the superclass constructor but before the class constructor.
	// - Traits are constructed left-to-right.
	// - Within each trait, the parents get constructed first.
	// - If multiple traits share a common parent, and that parent has already been constructed, it is not constructed again.
	// - After all traits are constructed, the subclass is constructed.
	//e.g. class SavingsAccount extends Account with FileLogger with ShortLogger
	// 1 - Account (the superclass)
	// 2 - Logger (the parent of the first trait)
	// 3 - FileLogger (the first trait)
	// 4 - ShortLogger (the second trait, Logger parent already constructed)
	// 5 - SavingsAccount (the class)
	
	//10.11 Initializing Trait Fields
}