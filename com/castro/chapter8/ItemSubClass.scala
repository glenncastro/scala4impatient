package com.castro.chapter8

class ItemSubClass(override val description: String, override val price: Double) extends 
	Item(description, price) {

}