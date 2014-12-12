package com.castro.chapter10

trait Logger {
  def log(msg: String) // An abstract method
  def info(msg: String) { log("INFO: " + msg) }
  def warn(msg: String) { log("WARN: " + msg) }
  def severe(msg: String) { log("SEVERE: " + msg)}
}