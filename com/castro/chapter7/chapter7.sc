package com.castro.chapter7

object chapter7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // Chapter 7 - Packages and Imports
  //7.1 - Packages
  val employee = new com.castro.chapter7.Employees//> employee  : com.castro.chapter7.Employees = com.castro.chapter7.Employees@44
                                                  //| dd7637
  val manager = new com.castro.chapter7.Managers  //> manager  : com.castro.chapter7.Managers = com.castro.chapter7.Managers@3eb7d
                                                  //| 774
  val counter = new org.bigjava.Counter           //> counter  : org.bigjava.Counter = org.bigjava.Counter@151a0f60
  
  //7.2 - Scope Rules
  //7.3 - Chained Package Clauses
  //7.4 - Top-of-File Notation
  
  //7.5 - Package Objects
  val p1 = new people.Person1                     //> p1  : com.castro.chapter7.people.Person1 = com.castro.chapter7.people.Person
                                                  //| 1@6998e5d9
  p1.name                                         //> res0: String = John Q. Public
  
  //7.6 - Package Visibility
  
  //7.7 - Imports
  import java.awt.Color._
  //val c1 = RED
  // Color.RED
  //val c2 = decode("#ff0000")
  //Color.decode
  
  //7.8 - Imports Can Be Anywhere
  
  //7.9 - Renaming and Hiding Members
  import java.awt.{Color, Font}
  import java.util.{HashMap => JavaHashMap}
  import java.util.{HashMap => _, _}
  
  //7.10 - Implicit Imports
  /*
  import java.lang._
  import scala._
  import Predef._
  */
}