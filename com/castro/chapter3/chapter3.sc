package com.castro.chapter3

object chapter3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //3.1 Fixed-Length Arrays
  val nums = new Array[Int](10)                   //> nums  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  val a = new Array[String](10)                   //> a  : Array[String] = Array(null, null, null, null, null, null, null, null, n
                                                  //| ull, null)
  val s = Array("Hello", "World")                 //> s  : Array[String] = Array(Hello, World)
  s(0) = "Goodbye"
  s                                               //> res0: Array[String] = Array(Goodbye, World)
  
  //3.2 Variable-Length Arrays: Array Buffers
  import scala.collection.mutable.ArrayBuffer
  val b = ArrayBuffer[Int]()                      //> b  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  val b1 = new ArrayBuffer[Int]                   //> b1  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  b += 1                                          //> res1: com.castro.chapter3.chapter3.b.type = ArrayBuffer(1)
  b += (1,2,3,5)                                  //> res2: com.castro.chapter3.chapter3.b.type = ArrayBuffer(1, 1, 2, 3, 5)
  b ++= Array(8,13,21)                            //> res3: com.castro.chapter3.chapter3.b.type = ArrayBuffer(1, 1, 2, 3, 5, 8, 13
                                                  //| , 21)
  b.trimEnd(5)
  b                                               //> res4: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2)
  b.insert(2,6)
  b                                               //> res5: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 6, 2)
 	b.insert(2,7,8,9)
 	b                                         //> res6: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 7, 8, 9,
                                                  //|  6, 2)
 	b.remove(2)                               //> res7: Int = 7
 	b                                         //> res8: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 8, 9, 6,
                                                  //|  2)
 	b.remove(2,3)
 	b.toArray                                 //> res9: Array[Int] = Array(1, 1, 2)
 
  //3.3 Traversing Arrays and Array Buffers
  val pagbati = "Hola"                            //> pagbati  : String = Hola
  for (i <- 0 until pagbati.length) {
  	println(i + ": " + pagbati(i))            //> 0: H
                                                  //| 1: o
                                                  //| 2: l
                                                  //| 3: a
  }
  0 until 5                                       //> res10: scala.collection.immutable.Range = Range(0, 1, 2, 3, 4)
  0.until(5)                                      //> res11: scala.collection.immutable.Range = Range(0, 1, 2, 3, 4)
  0 until (pagbati.length, 2)                     //> res12: scala.collection.immutable.Range = Range(0, 2)
  (0 until pagbati.length).reverse                //> res13: scala.collection.immutable.Range = Range(3, 2, 1, 0)
  for (elem <- pagbati) println(elem)             //> H
                                                  //| o
                                                  //| l
                                                  //| a
  
  //3.4 Transforming Arrays
  var arr = ArrayBuffer(2,3,4,5,7,11,-1,-2,0,12)  //> arr  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(2, 3, 4, 5, 7
                                                  //| , 11, -1, -2, 0, 12)
  val result = for (elem <- arr) yield 2 * elem   //> result  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(4, 6, 8, 1
                                                  //| 0, 14, 22, -2, -4, 0, 24)
  for (elem <- arr if elem % 2 == 0) yield 2 * elem
                                                  //> res14: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(4, 8, -4, 0,
                                                  //|  24)
  arr.filter(_ % 2 == 0).map(2 * _)               //> res15: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(4, 8, -4, 0,
                                                  //|  24)
  arr filter {_ % 2 == 0} map {2 * _}             //> res16: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(4, 8, -4, 0,
                                                  //|  24)
  var first = true                                //> first  : Boolean = true
  var n = arr.length                              //> n  : Int = 10
  var i = 0                                       //> i  : Int = 0
  while(i < n) {
  	if (arr(i) >= 0) i += 1
  	else {
  		if (first) { first = false; i += 1 }
  		else { arr.remove(i); n -= 1 }
  	}
  }
  arr                                             //> res17: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(2, 3, 4, 5, 
                                                  //| 7, 11, -1, 0, 12)
  var una = true                                  //> una  : Boolean = true
  val indexes = for (i <- 0 until arr.length if una || arr(i) >= 0) yield {
  	if (arr(i) < 0) una = false; i
  }                                               //> indexes  : scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 2, 3, 
                                                  //| 4, 5, 6, 7, 8)
  for (j <- 0 until indexes.length) arr(j) = arr(indexes(j))
  arr.trimEnd(arr.length - indexes.length)
  arr                                             //> res18: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(2, 3, 4, 5, 
                                                  //| 7, 11, -1, 0, 12)
  //3.5 Common Algorithms
  Array(1,7,2,9).sum                              //> res19: Int = 19
  ArrayBuffer("Mary", "had", "a", "little", "lamb").max
                                                  //> res20: String = little
	val bee = ArrayBuffer(1,7,2,9)            //> bee  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 7, 2, 9)
	val bSorted = bee.sorted                  //> bSorted  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 7,
                                                  //|  9)
	
	val ae = Array(1,7,2,9)                   //> ae  : Array[Int] = Array(1, 7, 2, 9)
	scala.util.Sorting.quickSort(ae)
	ae.mkString(" and ")                      //> res21: String = 1 and 2 and 7 and 9
	ae.mkString("<", ",",">")                 //> res22: String = <1,2,7,9>
	ae.toString                               //> res23: String = [I@2009d3af
	bee.toString                              //> res24: String = ArrayBuffer(1, 7, 2, 9)
	
	//3.6 Deciphering Scaladoc
	bee.count(_ > 0)                          //> res25: Int = 4
	
	//3.7 Multidimensional Arrays
	val matrix = Array.ofDim[Double](3, 4)    //> matrix  : Array[Array[Double]] = Array(Array(0.0, 0.0, 0.0, 0.0), Array(0.0
                                                  //| , 0.0, 0.0, 0.0), Array(0.0, 0.0, 0.0, 0.0))
  matrix(2)(2) = 42
  matrix                                          //> res26: Array[Array[Double]] = Array(Array(0.0, 0.0, 0.0, 0.0), Array(0.0, 0
                                                  //| .0, 0.0, 0.0), Array(0.0, 0.0, 42.0, 0.0))
  val triangle = new Array[Array[Int]](10)        //> triangle  : Array[Array[Int]] = Array(null, null, null, null, null, null, n
                                                  //| ull, null, null, null)
  for (i <- 0 until triangle.length)
  	triangle(i) = new Array[Int](i+1)
  	
 	//3.8 Interoperability with Java
 	//Scala to Java
 	import scala.collection.JavaConversions.bufferAsJavaList
 	import scala.collection.mutable.ArrayBuffer
 	val command = ArrayBuffer("ls", "-al", "/home/glenncastro")
                                                  //> command  : scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(ls, -
                                                  //| al, /home/glenncastro)
 	val pb = new ProcessBuilder(command)      //> pb  : ProcessBuilder = java.lang.ProcessBuilder@2011bdde
 	
 	//Java to Scala
 	import scala.collection.JavaConversions.asScalaBuffer
 	import scala.collection.mutable.Buffer
 	val cmd : Buffer[String] = pb.command()   //> cmd  : scala.collection.mutable.Buffer[String] = ArrayBuffer(ls, -al, /home
                                                  //| /glenncastro)
 	val tz = java.util.TimeZone.getAvailableIDs()
                                                  //> tz  : Array[String] = Array(Etc/GMT+12, Etc/GMT+11, Pacific/Midway, Pacific
                                                  //| /Niue, Pacific/Pago_Pago, Pacific/Samoa, US/Samoa, America/Adak, America/At
                                                  //| ka, Etc/GMT+10, HST, Pacific/Honolulu, Pacific/Johnston, Pacific/Rarotonga,
                                                  //|  Pacific/Tahiti, SystemV/HST10, US/Aleutian, US/Hawaii, Pacific/Marquesas, 
                                                  //| AST, America/Anchorage, America/Juneau, America/Nome, America/Sitka, Americ
                                                  //| a/Yakutat, Etc/GMT+9, Pacific/Gambier, SystemV/YST9, SystemV/YST9YDT, US/Al
                                                  //| aska, America/Dawson, America/Ensenada, America/Los_Angeles, America/Metlak
                                                  //| atla, America/Santa_Isabel, America/Tijuana, America/Vancouver, America/Whi
                                                  //| tehorse, Canada/Pacific, Canada/Yukon, Etc/GMT+8, Mexico/BajaNorte, PST, PS
                                                  //| T8PDT, Pacific/Pitcairn, SystemV/PST8, SystemV/PST8PDT, US/Pacific, US/Paci
                                                  //| fic-New, America/Boise, America/Cambridge_Bay, America/Chihuahua, America/C
                                                  //| reston, America/Dawson_Creek, America/Denver, America/Edmonton, America/Her
                                                  //| mosillo, America/Inuvik
                                                  //| Output exceeds cutoff limit.
 	val newTz = for (item <- tz if item.indexOf('/') > 0) yield {
 		val idx = item.indexOf('/')
 		item.substring(idx + 1)
 	}                                         //> newTz  : Array[String] = Array(GMT+12, GMT+11, Midway, Niue, Pago_Pago, Sam
                                                  //| oa, Samoa, Adak, Atka, GMT+10, Honolulu, Johnston, Rarotonga, Tahiti, HST10
                                                  //| , Aleutian, Hawaii, Marquesas, Anchorage, Juneau, Nome, Sitka, Yakutat, GMT
                                                  //| +9, Gambier, YST9, YST9YDT, Alaska, Dawson, Ensenada, Los_Angeles, Metlakat
                                                  //| la, Santa_Isabel, Tijuana, Vancouver, Whitehorse, Pacific, Yukon, GMT+8, Ba
                                                  //| jaNorte, Pitcairn, PST8, PST8PDT, Pacific, Pacific-New, Boise, Cambridge_Ba
                                                  //| y, Chihuahua, Creston, Dawson_Creek, Denver, Edmonton, Hermosillo, Inuvik, 
                                                  //| Mazatlan, Ojinaga, Phoenix, Shiprock, Yellowknife, Mountain, GMT+7, BajaSur
                                                  //| , MST7, MST7MDT, Arizona, Mountain, Bahia_Banderas, Belize, Cancun, Chicago
                                                  //| , Costa_Rica, El_Salvador, Guatemala, Indiana/Knox, Indiana/Tell_City, Knox
                                                  //| _IN, Managua, Matamoros, Menominee, Merida, Mexico_City, Monterrey, North_D
                                                  //| akota/Beulah, North_Dakota/Center, North_Dakota/New_Salem, Rainy_River, Ran
                                                  //| kin_Inlet, Regina, Reso
                                                  //| Output exceeds cutoff limit.
 	newTz.sorted                              //> res27: Array[String] = Array(ACT, AST4, AST4ADT, Abidjan, Accra, Acre, Adak
                                                  //| , Addis_Ababa, Adelaide, Aden, Alaska, Aleutian, Algiers, Almaty, Amman, Am
                                                  //| sterdam, Anadyr, Anchorage, Andorra, Anguilla, Antananarivo, Antigua, Apia,
                                                  //|  Aqtau, Aqtobe, Araguaina, Argentina/Buenos_Aires, Argentina/Catamarca, Arg
                                                  //| entina/ComodRivadavia, Argentina/Cordoba, Argentina/Jujuy, Argentina/La_Rio
                                                  //| ja, Argentina/Mendoza, Argentina/Rio_Gallegos, Argentina/Salta, Argentina/S
                                                  //| an_Juan, Argentina/San_Luis, Argentina/Tucuman, Argentina/Ushuaia, Arizona,
                                                  //|  Aruba, Ashgabat, Ashkhabad, Asmara, Asmera, Asuncion, Athens, Atikokan, At
                                                  //| ka, Atlantic, Auckland, Azores, Baghdad, Bahia, Bahia_Banderas, Bahrain, Ba
                                                  //| jaNorte, BajaSur, Baku, Bamako, Bangkok, Bangui, Banjul, Barbados, Beirut, 
                                                  //| Belem, Belfast, Belgrade, Belize, Berlin, Bermuda, Bishkek, Bissau, Blanc-S
                                                  //| ablon, Blantyre, Boa_Vista, Bogota, Boise, Bratislava, Brazzaville, Brisban
                                                  //| e, Broken_Hill, Brunei,
                                                  //| Output exceeds cutoff limit.
}