package greeter

object greeter {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sorts(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      println("pivot " + pivot)
      Array.concat(
          sorts(xs filter (pivot >)),
          xs filter (pivot ==),
          sorts(xs filter (pivot <))
      )
    }
  }                                               //> sorts: (xs: Array[Int])Array[Int]
  
  val arr = sorts(Array(1,3,5,2,4))               //> pivot 5
                                                  //| pivot 2
                                                  //| pivot 4
                                                  //| arr  : Array[Int] = Array(1, 2, 3, 4, 5)
  var arr1 = Array(2,1,3,5,6,9,7,4)               //> arr1  : Array[Int] = Array(2, 1, 3, 5, 6, 9, 7, 4)
  arr1.length                                     //> res0: Int = 8
  val pivot1 = arr1(arr1.length /2)               //> pivot1  : Int = 6
  var arr2 = arr1 filter (pivot1 > )              //> arr2  : Array[Int] = Array(2, 1, 3, 5, 4)
  var arr3 = arr1 filter (pivot1 ==)              //> arr3  : Array[Int] = Array(6)
  var arr4 = arr1 filter (pivot1 < )              //> arr4  : Array[Int] = Array(9, 7)
  
  def loop: Boolean = loop                        //> loop: => Boolean
	//def - call by name
	def x = loop                              //> x: => Boolean
	//val - call by value
	//val x = loop
	
	//x - CBV, y - CBN
	def and(x: Boolean, y: => Boolean) = {
		if (x) y else false
	}                                         //> and: (x: Boolean, y: => Boolean)Boolean
	and(true, false)                          //> res1: Boolean = false
	and(true, true)                           //> res2: Boolean = true
	and(false, true)                          //> res3: Boolean = false
	and(false, false)                         //> res4: Boolean = false
	and(false, loop)                          //> res5: Boolean = false
}