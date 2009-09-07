package scala.sandbox.tests


import java.lang.Math;

case class AllPrimes() {
	def foreach(f : (Int) => Unit) {
	  var i:Int = 2;
	  while(true) {
		f(i)
		i+=1;
	    while(!isPrime(i)) {
	      i += 1;
	  }
	}
   }
 
   def isPrime(n: Int): Boolean =  {
    val sqrtN = Math.sqrt(n.asInstanceOf[Double]).asInstanceOf[Int];
    for (x <- 2 until sqrtN+1) {
        if (n % x == 0) {
            return false;
        }
    }
    return true;     
   }
   
 }



object Primes {
    def main(args : Array[String]) : Unit = {
      for(n <- AllPrimes()) {
        println(n);
      }
  }
    
}

