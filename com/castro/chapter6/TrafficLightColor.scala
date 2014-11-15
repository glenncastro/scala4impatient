package com.castro.chapter6

object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value
//  val Red, Yellow, Green = Value
  val Red = Value(0, "Stop")
  val Yellow = Value(10) // Name "Yellow"
  val Green = Value("Go") // ID 11
}