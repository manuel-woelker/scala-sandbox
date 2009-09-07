package scala.sandbox.tests

object ChurchCalculus {
  def main(args : Array[String]) : Unit = {
    xprint(True);
    xprint(False);
    xprint(Or(True[C[Boolean]],False[Boolean]));
    tprint(And(True[C[Boolean]],False[Boolean]));
  }

  type C[T] = (T, T)=>T
  
  def True[T](a:T, b:T) : T = {
	  a
  }
  
  def False[T](a:T, b:T) : T = {
	  b
  }
  
//  def Or[T,F >: C[T] <: C[T] ](f:T, g:T): T = {
    def Or[T](f:C[C[T]], g:C[T]): C[T] =  {
    return f(True[T], g)
  }
    def And[T](f:C[C[T]], g:C[T]): C[T] =  {
    return f(g, False[T])
  }
//  def Or[T](f:(T, T)=>T, g:(T, T)=>T)  {
//    return f(True, False)
//  }
  
  def xprint(f:(Boolean, Boolean)=>Boolean) {
    println(f(true, false));
  }

  def tprint(f:C[Boolean]) {
    println(f(true, false));
  }
  
}


