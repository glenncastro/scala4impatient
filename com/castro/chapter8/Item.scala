package com.castro.chapter8

class Item(val description: String, val price: Double) {

  final override def equals(other: Any) = {
    val that = other.asInstanceOf[Item]
    if (that == null) false
    else description == that.description && price == that.price
  }
}