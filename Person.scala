package com.castro.chapter7 {
  package people {
    class Person {
      private var name = "Unknown"
      private[chapter7] def description = "A person with name " + name
    }
  }
}

//testing the visibility of description above
package com {
  package castro {
    package chapter7 {
      class P1 {
        val v = new people.Person
        v.description
      }
    }
  }
}

// or

/*
package com.castro.chapter7
package people

class Person {
  
}
*/