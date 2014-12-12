package com.castro.chapter10.exercises

import java.awt.geom.Ellipse2D
import java.awt.Shape

trait RectangleLike extends Ellipse2D.Double {
  
  def translate(x: Int, y: Int) {
//    super.translate(x, y)
  }

  def grow(x: Int, y: Int) {
//    super.grow(x, y)
  }
  
}