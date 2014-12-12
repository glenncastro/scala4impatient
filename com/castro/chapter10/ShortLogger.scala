package com.castro.chapter10

import scala.util.logging.Logged

trait ShortLogger extends Logged {
  val maxLength = 15 // A concrete field
  override def log(msg: String) {
    super.log(
        if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
    )
  }

}