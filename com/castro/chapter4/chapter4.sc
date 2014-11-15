package com.castro.chapter4

object chapter4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //Chapter 4:  Maps and Tuples
  //4.1 Constructing a Map
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
                                                  //> scores  : scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob 
                                                  //| -> 3, Cindy -> 8)
  var scores1 = Map(("Alice",10), ("Bob",3), ("Cindy",8))
                                                  //> scores1  : scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob
                                                  //|  -> 3, Cindy -> 8)
  //mutable maps
  val scoresMutable = scala.collection.mutable.Map("Alice" -> 3, "Bob" -> 3, "Cindy" -> 8)
                                                  //> scoresMutable  : scala.collection.mutable.Map[String,Int] = Map(Bob -> 3, Al
                                                  //| ice -> 3, Cindy -> 8)
  val scoresMap = new scala.collection.mutable.HashMap[String, Int]
                                                  //> scoresMap  : scala.collection.mutable.HashMap[String,Int] = Map()
  
  //4.2 Accessing Map Values
  val bobsScore = scores("Bob")                   //> bobsScore  : Int = 3
  val bobsScore1 = if (scores.contains("Bob")) scores("Bob") else 0
                                                  //> bobsScore1  : Int = 3
  val bobsScore2 = scores.getOrElse("Bobsy", 0)   //> bobsScore2  : Int = 0
  
  //4.3 Updating Map Values
  scoresMutable                                   //> res0: scala.collection.mutable.Map[String,Int] = Map(Bob -> 3, Alice -> 3, C
                                                  //| indy -> 8)
  scoresMutable("Bob") = 10
  scoresMutable("Fred") = 7
  scoresMutable                                   //> res1: scala.collection.mutable.Map[String,Int] = Map(Bob -> 10, Fred -> 7, A
                                                  //| lice -> 3, Cindy -> 8)
  scoresMap                                       //> res2: scala.collection.mutable.HashMap[String,Int] = Map()
  scoresMap += ("Bob" -> 10, "Fred" -> 7)         //> res3: com.castro.chapter4.chapter4.scoresMap.type = Map(Bob -> 10, Fred -> 7
                                                  //| )
  scoresMap                                       //> res4: scala.collection.mutable.HashMap[String,Int] = Map(Bob -> 10, Fred -> 
                                                  //| 7)
  
  scoresMutable -= "Alice"                        //> res5: com.castro.chapter4.chapter4.scoresMutable.type = Map(Bob -> 10, Fred 
                                                  //| -> 7, Cindy -> 8)
  //immutable val scores
  val newScores = scores + ("Bob" -> 10, "Fred" -> 7)
                                                  //> newScores  : scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, B
                                                  //| ob -> 10, Cindy -> 8, Fred -> 7)
  //immutable var scores1
  scores1 = scores1 + ("Bob" -> 10, "Fred" -> 7)
  scores1 = scores1 - "Alice"
  
  //4.4 Iterating over Maps
  scores.keySet                                   //> res6: scala.collection.immutable.Set[String] = Set(Alice, Bob, Cindy)
  for (v <- scores.values) println(v)             //> 10
                                                  //| 3
                                                  //| 8
	for((k,v) <- scores) yield (v,k)          //> res7: scala.collection.immutable.Map[Int,String] = Map(10 -> Alice, 3 -> Bo
                                                  //| b, 8 -> Cindy)
	
	//4.5 Sorted Maps
	val scoresSorted = scala.collection.immutable.SortedMap("Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)
                                                  //> scoresSorted  : scala.collection.immutable.SortedMap[String,Int] = Map(Alic
                                                  //| e -> 10, Bob -> 3, Cindy -> 8, Fred -> 7)
	
	val months = scala.collection.mutable.LinkedHashMap("January" -> 1, "February" -> 2, "March" -> 3, "April" -> 4, "May" -> 5, "June" -> 6, "July" -> 7, "August" -> 8, "September" -> 9, "October" -> 10, "November" -> 11, "December" -> 12)
                                                  //> months  : scala.collection.mutable.LinkedHashMap[String,Int] = Map(January 
                                                  //| -> 1, February -> 2, March -> 3, April -> 4, May -> 5, June -> 6, July -> 7
                                                  //| , August -> 8, September -> 9, October -> 10, November -> 11, December -> 1
                                                  //| 2)
	
	//4.6 Interoperating with Java
	//Java to Scala
	import scala.collection.JavaConversions.mapAsScalaMap
	val scored: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
                                                  //> scored  : scala.collection.mutable.Map[String,Int] = Map()
	
	import scala.collection.JavaConversions.propertiesAsScalaMap
	val props: scala.collection.Map[String, String] = System.getProperties()
                                                  //> props  : scala.collection.Map[String,String] = Map(java.runtime.name -> Jav
                                                  //| a(TM) SE Runtime Environment, sun.boot.library.path -> /Library/Java/JavaVi
                                                  //| rtualMachines/jdk1.7.0_51.jdk/Contents/Home/jre/lib, java.vm.version -> 24.
                                                  //| 51-b03, user.country.format -> AU, gopherProxySet -> false, java.vm.vendor 
                                                  //| -> Oracle Corporation, java.vendor.url -> http://java.oracle.com/, path.sep
                                                  //| arator -> :, java.vm.name -> Java HotSpot(TM) 64-Bit Server VM, file.encodi
                                                  //| ng.pkg -> sun.io, user.country -> US, sun.java.launcher -> SUN_STANDARD, su
                                                  //| n.os.patch.level -> unknown, java.vm.specification.name -> Java Virtual Mac
                                                  //| hine Specification, user.dir -> /Users/glenncastro/Applications/eclipse/Ecl
                                                  //| ipse.app/Contents/MacOS, java.runtime.version -> 1.7.0_51-b13, java.awt.gra
                                                  //| phicsenv -> sun.awt.CGraphicsEnvironment, java.endorsed.dirs -> /Library/Ja
                                                  //| va/JavaVirtualMachines/jdk1.7.0_51.jdk/Contents/Home/jre/lib/endorsed, os.a
                                                  //| rch -> x86_64, java.io.
                                                  //| Output exceeds cutoff limit.
	
	//Scala to Java
	import scala.collection.JavaConversions.mapAsJavaMap
	import java.awt.font.TextAttribute._
//	val attrs = Map(FAMILY -> "Serif", SIZE -> 12)
//	val font = new java.awt.Font(attrs)
	
	
	
	//4.7 Tuples
	val t = (1, 3.14, "Fred")                 //> t  : (Int, Double, String) = (1,3.14,Fred)
	val second = t._2                         //> second  : Double = 3.14
  
  //val (first, second, third) = t
  val (first, _, third) = t                       //> first  : Int = 1
                                                  //| third  : String = Fred
  "New York".partition(_.isUpper)                 //> res8: (String, String) = (NY,ew ork)
  
  
  //4.8 Zipping
  val symbols = Array("<", "-", ">")              //> symbols  : Array[String] = Array(<, -, >)
  val counts = Array(2,10,2)                      //> counts  : Array[Int] = Array(2, 10, 2)
  val pairs = symbols.zip(counts)                 //> pairs  : Array[(String, Int)] = Array((<,2), (-,10), (>,2))
  //processed together:
  for ((s,n) <- pairs) Console.println(s * n)     //> <<
                                                  //| ----------
                                                  //| >>
  
  "Hello".zip("World")                            //> res9: scala.collection.immutable.IndexedSeq[(Char, Char)] = Vector((H,W), (
                                                  //| e,o), (l,r), (l,l), (o,d))
}