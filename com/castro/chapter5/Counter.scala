package com.castro.chapter5

class Counter {

  private var value = 0;
  
  def increment() { value += 1}
  def current = value
  
  def isLess(other: Counter) = value < other.value
}