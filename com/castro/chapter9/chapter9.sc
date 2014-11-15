package com.castro.chapter9

object chapter9 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //Chapter 9 - Files and Regular Expressions
  
  //9.1 Reading Lines
  import scala.io.Source
  val source = Source.fromFile("/Users/glenncastro/football/myfile.txt", "UTF-8")
                                                  //> source  : scala.io.BufferedSource = non-empty iterator
  for(c <- source) print("<" + c + ">")           //> <1><0>< ><2><0><
                                                  //| ><3><0>
  val lineIterator = source.getLines              //> lineIterator  : Iterator[String] = empty iterator
  for (l <- lineIterator) println("***" + l + "***")
  val lines = source.getLines.toArray             //> lines  : Array[String] = Array()
  val contents = source.mkString                  //> contents  : String = ""
  source.close
  
  //9.2 Reading Characters
  val src = Source.fromFile("/Users/glenncastro/football/myfile.txt", "UTF-8")
                                                  //> src  : scala.io.BufferedSource = non-empty iterator
  //val iter = src.buffered
  
  //9.3 Reading Tokens and Numbers
  val tokens = src.mkString.split("\\s+")         //> tokens  : Array[String] = Array(10, 20, 30)
  val numbers = for (w <- tokens) yield w.toDouble//> numbers  : Array[Double] = Array(10.0, 20.0, 30.0)
  val numbers1 = tokens.map(_.toDouble)           //> numbers1  : Array[Double] = Array(10.0, 20.0, 30.0)
  
  //9.4 Reading from URLs and Other Sources
  //val source1 = Source.fromURL("http://horstmann.com", "UTF-8")
  val source2 = Source.fromString("Hello, World!")//> source2  : scala.io.Source = non-empty iterator
  //val source3 = Source.stdin
  
  //9.5 Reading Binary Files
  
  //9.6 Writing Text Files
  
  //9.7 Visiting Directories
  
  //9.8 Serialization
  @SerialVersionUID(42L) class Person extends Serializable
  val fred = new Person                           //> fred  : com.castro.chapter9.chapter9.Person = com.castro.chapter9.chapter9$
                                                  //| $anonfun$main$1$Person$1@6a13a848
  import java.io._
  val out = new ObjectOutputStream(new FileOutputStream("/Users/glenncastro/football/test.obj"))
                                                  //> out  : java.io.ObjectOutputStream = java.io.ObjectOutputStream@1f2e930f
  out.writeObject(fred)
  out.close
  val in = new ObjectInputStream(new FileInputStream("/Users/glenncastro/football/test.obj"))
                                                  //> in  : java.io.ObjectInputStream = java.io.ObjectInputStream@3df6c65c
  val savedFred = in.readObject().asInstanceOf[Person]
                                                  //> savedFred  : com.castro.chapter9.chapter9.Person = com.castro.chapter9.chap
                                                  //| ter9$$anonfun$main$1$Person$1@1458e1cc
  
  //9.9 Process Control
  
  //9.10 Regular Expressions
  val numPattern = "[0-9]+".r                     //> numPattern  : scala.util.matching.Regex = [0-9]+
  val wsnumwsPattern = """\s+[0-9]+\s+""".r       //> wsnumwsPattern  : scala.util.matching.Regex = \s+[0-9]+\s+
  for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles"))
  	println(matchString)                      //> 99
                                                  //| 98
  val matches = numPattern.findAllIn("99 bottles, 98 bottles").toArray
                                                  //> matches  : Array[String] = Array(99, 98)
  val m1 = wsnumwsPattern.findFirstIn("99 bottles, 98 bottles")
                                                  //> m1  : Option[String] = Some( 98 )
  numPattern.findPrefixOf("99 bottles, 98 bottles")
                                                  //> res0: Option[String] = Some(99)
  wsnumwsPattern.findPrefixOf("99 bottles, 98 bottles")
                                                  //> res1: Option[String] = None
  numPattern.replaceFirstIn("99 bottles, 98 bottles", "XX")
                                                  //> res2: String = XX bottles, 98 bottles
  numPattern.replaceAllIn("99 bottles, 98 bottles", "XX")
                                                  //> res3: String = XX bottles, XX bottles
  //9.11 Regular Expression Groups
  val numitemPattern = "([0-9]+) ([a-z]+)".r      //> numitemPattern  : scala.util.matching.Regex = ([0-9]+) ([a-z]+)
  val numitemPattern(num, item) = "99 bottles"    //> num  : String = 99
                                                  //| item  : String = bottles
}