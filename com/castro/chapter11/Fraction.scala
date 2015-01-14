package com.castro.chapter11

// (n1 / d1) x (n2 / d2) = (n1n2 / d1/d1)
class Fraction(n: Int, d: Int) {
  val num = n
  val den = d
  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
  
  def unapply(input: Fraction) =
    if (input.den == 0) None else Some((input.num, input.den))
}