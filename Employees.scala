package com {
  package castro {
    
    object Utils {
      def percentOf(value: Double, rate: Double) = value * rate / 100
    }
    
    package chapter7 {
      class Employees {
        private var salary = 0.0
        def giveRaise(rate: scala.Double) {
          salary += Utils.percentOf(salary, rate)
        }
        
      }
    }
  }
}

package org {
  package bigjava {
    class Counter {
      
    }
  }
}