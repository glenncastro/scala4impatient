package com.castro.chapter8

class Employee1(name: String) extends Person1(name) {
  def id = name.hashCode
}