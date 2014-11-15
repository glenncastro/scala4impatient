package com.castro.chapter8

class Employee(name: String, age: Int, val salary: Double) extends 
	Person(name, age) {
  override def toString = super.toString + "[salary=" + salary + "]"

}