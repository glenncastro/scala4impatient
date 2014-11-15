package com.castro.chapter7

package object people {
  val defaultName = "John Q. Public"
}

package people {
  class Person1 {
    var name = defaultName //A constant from the package
  }
}
