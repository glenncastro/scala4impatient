package com.castro.chapter8

class SecretAgent(codename: String, age: Int) extends Person(codename, age) {
  override val name = "secret" // Don't want to reveal name...
  override val toString = "secret" // ...or class name
}