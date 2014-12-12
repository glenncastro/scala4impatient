package com.castro.chapter10

class SavingsAccount extends Account with Logger {
  def withdraw(amount: Double) {
    if (amount > balance) severe("Insufficient funds")
    else balance -= amount
  }
  
  override def log(msg: String) { println(msg) }
  
}