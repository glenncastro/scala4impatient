package com.castro.chapter5

class BankAccount {
  private var balance = 0
  
  def deposit(amount: Int) {
    balance += amount
  }
  
  def withdraw(amount: Int) {
    balance -= amount
  }
}