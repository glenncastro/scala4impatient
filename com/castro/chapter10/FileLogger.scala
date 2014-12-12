package com.castro.chapter10

import java.io.PrintWriter
import java.util.Date

trait FileLogger extends Logger {

  val out = new PrintWriter("app.log") //Part of the trait's constructor
  out.println("#" + new Date().toString()) // Also part of the constructor
  
  def log(msg: String) { out.println(msg); out.flush() }
}