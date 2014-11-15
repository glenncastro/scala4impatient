package com.castro.chapter5

class Person {
  private var privateAge = 0
  
  def age = privateAge
  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue; // Can't get younger
  }
}