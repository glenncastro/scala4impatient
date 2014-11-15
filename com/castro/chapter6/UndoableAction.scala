package com.castro.chapter6

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}