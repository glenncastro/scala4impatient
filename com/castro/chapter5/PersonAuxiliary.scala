package com.castro.chapter5

class PersonAuxiliary {
	private var name = ""
	private var age = 0
	
	def this(name: String) {
	  this()
	  this.name = name
	}
	
	def this(name: String, age: Int) {
	  this(name)
	  this.age = age
	}
}