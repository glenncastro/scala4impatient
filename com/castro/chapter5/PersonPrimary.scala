package com.castro.chapter5

// Note: If a parameter without val or var is used inside at least one method, it becomes a field
// e.g. class Person(name: String, age: Int) { def description = name + " is " + age + " years old."; }
// object-private equivalent to private[this] val
class PersonPrimary(val name: String = "", private val age: Int = 0) {
	println("Just constructed another person")
	def description = name + " is " + age + " years old"
}