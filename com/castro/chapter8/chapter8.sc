package com.castro.chapter8

object chapter8 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //Chapter 8 - Inheritance
  
  //8.1 Extending a Class
  
  //8.2 Overriding Methods
  
  //8.3 Type Checks and Casts
  val p = new Manager("Glenn", 33, 90000.0)       //> p  : com.castro.chapter8.Manager = com.castro.chapter8.Manager[name=Glenn][s
                                                  //| alary=90000.0]
  if (p.isInstanceOf[Employee]) {
  	val s = p.asInstanceOf[Employee]
  	s
  }                                               //> res0: Any = com.castro.chapter8.Manager[name=Glenn][salary=90000.0]
  
  if (p.getClass == classOf[Employee]) p          //> res1: Any = ()
  /*
  p match {
  	case s: Employee => ??? // Process s as an Employee
  	case _ => ??? //p wasn't an Employee
  }
  */
  
  //8.4 Protected Fields and Methods
  
  //8.5 Superclass Construction
  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width)
  
  //8.6 Overriding Fields
  // Override val with val (OK), with def (Error), with var (Error)
  // Override def with val (OK), with def (Like in Java), with var (getter/setter pair)
  // Override var with val (Error), with def (Error), with var (if superclass is abstract)
  
  //8.7 Anonymous Subclasses
  val alien = new Person("Glenn", 33) {
  	def greeting = "Greetings, Earthling! My name is Glenn."
  }                                               //> alien  : com.castro.chapter8.Person{def greeting: String} = com.castro.chap
                                                  //| ter8.chapter8$$anonfun$main$1$$anon$1[name=Glenn]
  
  def meet(p: Person{def greeting: String}) {
  	println(p.name + " says: " + p.greeting)
  }                                               //> meet: (p: com.castro.chapter8.Person{def greeting: String})Unit
  
  //8.8 Abstract Classes
  abstract class Person2 {
  	def id: Int
  }
  
  //8.9 Abstract Fields
  abstract class Person3 {
  	val id: Int
  	var name: String
  }
  
  // anonymous type
  val glenn = new Person3 {
  	val id = 1729
  	var name = "Glenn"
  }                                               //> glenn  : com.castro.chapter8.chapter8.Person3 = com.castro.chapter8.chapter
                                                  //| 8$$anonfun$main$1$$anon$2@675dd521
  //8.10 Construction Order and Early Definitions
  
  //8.11 The Scala Inheritance Hierarchy
  // Unit () - is void in Java
  // AnyRef - objects; AnyVal - Boolean/Int/etc.
  // Null is null
  // empty list Nil has type List[Nothing]
  
  //8.12 Object Equality
  val item1 = new Item("Scala Book", 40.0)        //> item1  : com.castro.chapter8.Item = com.castro.chapter8.Item@35203c7f
  val item2 = new Item("Scala Book", 40)          //> item2  : com.castro.chapter8.Item = com.castro.chapter8.Item@5763d118
  val item3 = new ItemSubClass("Scala Book", 40.0)//> item3  : com.castro.chapter8.ItemSubClass = com.castro.chapter8.ItemSubClas
                                                  //| s@5e48a0e1
  item1.equals(item2)                             //> res2: Boolean = true
  item2.equals(item1)                             //> res3: Boolean = true
  item1.equals(item3)                             //> res4: Boolean = true
  item3.equals(item1)                             //> res5: Boolean = true
  item2.equals(item3)                             //> res6: Boolean = true
  item3.equals(item2)                             //> res7: Boolean = true
}