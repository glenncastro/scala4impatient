package com.castro.chapter12

object Tester {

  def main(args: Array[String]) {
    val a = 0;
    println("This is it")
    def submain() {
      val b = 1
      println("submain()")
      def subsubmain() {
        val c = a;
        val d = b;
        println("subsubmain")
        println(a + " " + b + " " + c + " " + d)
      }
      subsubmain()
    }
    
    submain()
  }
}