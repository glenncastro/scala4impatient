package com.castro.chapter5

object chapter5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //5.1 Simple Classes and Parameterless Methods
  val myCounter = new Counter                     //> myCounter  : com.castro.chapter5.Counter = com.castro.chapter5.Counter@6f440
                                                  //| a7a
  myCounter.increment()
  println(myCounter.current)                      //> 1
  
  //5.2 Properties with Getters and Setters
  val glenn = new Person                          //> glenn  : com.castro.chapter5.Person = com.castro.chapter5.Person@48abe515
  glenn.age = 34
  glenn.age = 27
  println(glenn.age)                              //> 34
  
  //5.3 Properties with Only Getters
  
  //5.4 Object-Private Fields
  val c1 = new Counter                            //> c1  : com.castro.chapter5.Counter = com.castro.chapter5.Counter@d4ceaf9
  c1.increment()
  c1.increment()
  val c2 = new Counter                            //> c2  : com.castro.chapter5.Counter = com.castro.chapter5.Counter@34d68841
  c2.increment()
  c1.isLess(c2)                                   //> res0: Boolean = false
  
  //5.5 Bean Properties
  val p = new PersonWithAnnotation                //> p  : com.castro.chapter5.PersonWithAnnotation = com.castro.chapter5.PersonWi
                                                  //| thAnnotation@5bc8e35a
  p.setName("Glenn")
  p.getName                                       //> res1: String = Glenn
  p.name = "Castro"
  p.getName                                       //> res2: String = Castro
  
  //5.6 Auxiliary Constructors
  val pa1 = new PersonAuxiliary                   //> pa1  : com.castro.chapter5.PersonAuxiliary = com.castro.chapter5.PersonAuxil
                                                  //| iary@50625c49
  val pa2 = new PersonAuxiliary("Glenn")          //> pa2  : com.castro.chapter5.PersonAuxiliary = com.castro.chapter5.PersonAuxil
                                                  //| iary@6998e5d9
  val pa3 = new PersonAuxiliary("Glenn", 33)      //> pa3  : com.castro.chapter5.PersonAuxiliary = com.castro.chapter5.PersonAuxil
                                                  //| iary@351a3fb8
  
  //5.7 The Primary Constructors
  val pp1 = new PersonPrimary                     //> Just constructed another person
                                                  //| pp1  : com.castro.chapter5.PersonPrimary = com.castro.chapter5.PersonPrimary
                                                  //| @b50daf
  pp1.description                                 //> res3: String = " is 0 years old"
  val pp2 = new PersonPrimary("Glenn", 33)        //> Just constructed another person
                                                  //| pp2  : com.castro.chapter5.PersonPrimary = com.castro.chapter5.PersonPrimary
                                                  //| @6e955c85
  pp2.description                                 //> res4: String = Glenn is 33 years old
  
  //5.8 Nested Classes
  val chatter = new Network                       //> chatter  : com.castro.chapter5.Network = com.castro.chapter5.Network@763c3a
                                                  //| 45
  val myFace = new Network                        //> myFace  : com.castro.chapter5.Network = com.castro.chapter5.Network@6c15c4a
                                                  //| 7
  val ted = chatter.join("Ted")                   //> ted  : com.castro.chapter5.chapter5.chatter.Member = com.castro.chapter5.Ne
                                                  //| twork$Member@43a05220
  val marshall = chatter.join("Marshall")         //> marshall  : com.castro.chapter5.chapter5.chatter.Member = com.castro.chapte
                                                  //| r5.Network$Member@526fd58f
  val lily = chatter.join("Lily")                 //> lily  : com.castro.chapter5.chapter5.chatter.Member = com.castro.chapter5.N
                                                  //| etwork$Member@2c2dc991
  ted.contacts += marshall                        //> res5: com.castro.chapter5.chapter5.ted.contacts.type = ArrayBuffer(com.cast
                                                  //| ro.chapter5.Network$Member@526fd58f)
  ted.contacts += lily                            //> res6: com.castro.chapter5.chapter5.ted.contacts.type = ArrayBuffer(com.cast
                                                  //| ro.chapter5.Network$Member@526fd58f, com.castro.chapter5.Network$Member@2c2
                                                  //| dc991)
  
  val barney = myFace.join("Barney")              //> barney  : com.castro.chapter5.chapter5.myFace.Member = com.castro.chapter5.
                                                  //| Network$Member@4ada629a
  //ted.contacts += barney
  
  
  
}