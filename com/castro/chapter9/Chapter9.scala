package com.castro.chapter9

import java.io.PrintWriter

object TestChapter9 {
  def main(args: Array[String]) {
	  print("How old are you? ")
	  //val age = readInt()
	  //print(age + " Philippines!")
	  
	  //Writing Text Files
	  /*
	  val out = new PrintWriter("numbers.txt")
	  for (i <- 1 to 100) out.println(i)
	  out.close()
	  */
	  
	  //Visiting Directories
	  import java.io.File
	  def subdirs(dir: File): Iterator[File] = {
	    val children = dir.listFiles().filter(_.isDirectory())
	    children.toIterator ++ children.toIterator.flatMap(subdirs _)
	  }
  }
}

