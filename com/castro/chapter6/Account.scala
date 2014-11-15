package com.castro.chapter6

// NOTE: Use object in Scala  whenever you would have used a singleton object in Java or C++
// - As a home for utility functions or constants
// - When a single immutable instance can be shared efficiently
// - When a single instance is required to coordinate some service (singleton design pattern)

// Companion Object
object Account {
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber }
}

class Account {
  val id = Account.newUniqueNumber()
  private var balance = 0.0
  def deposit(amount: Double) { balance += amount }
  def currentBalance = balance
}