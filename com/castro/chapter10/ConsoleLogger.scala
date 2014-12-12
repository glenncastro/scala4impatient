package com.castro.chapter10

class ConsoleLogger extends Logger { // Use extends, not implements
  def log(msg: String) { println(msg) } //No override needed
}

//more than one trait
class ConsoleLogger1 extends Logger with Cloneable with Serializable {
  def log(msg: String) { println(msg) }
}

trait ConsoleLoggerConcrete {
  def log(msg: String) { println(msg) }
}