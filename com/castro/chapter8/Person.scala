package com.castro.chapter8

class Person(val name: String = "Unknown", age: Int) {
  override def toString = getClass.getName + "[name=" + name + "]"
}