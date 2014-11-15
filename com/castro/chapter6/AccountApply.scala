package com.castro.chapter6

class AccountApply private (val id: Int, initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) { balance += amount}
  def currentBalance = balance
}

// companion object
object AccountApply {
  private var lastNumber = 0
  private def newUniqueNumber() = { lastNumber += 1; lastNumber }
  def apply(initialBalance: Double) = 
    new AccountApply(newUniqueNumber(), initialBalance)
}