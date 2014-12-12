package com.castro.chapter10

import scala.util.logging.Logged

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}