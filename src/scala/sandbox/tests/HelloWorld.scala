package scala.sandbox.tests;

import scala.concurrent.ops;
import java.lang.Thread;

object HelloWorld {
  def xcapitalize(string: String): String = {
    println(Thread.currentThread)
    return string.capitalize
  }
  def main(args : Array[String]) : Unit = {
    val text = "hello world"
    println (text.split(" ").map( xcapitalize).reduceLeft(_+" "+_) )
    println (parMap( xcapitalize, text.split(" ")).reduceLeft(_+" "+_)) 
    println (parMap( ((x:String) => {println(Thread.currentThread);"x.capitalize"}:String) , text.split(" ")).reduceLeft(_+" "+_)) 
    println("foo")
    List(1,2).reduceLeft(_+_)
  }
  
  def parMap[a,b](f: a => b, xs: Array[a]): Array[b] = {
    val results = new Array[b](xs.length);
    replicate(0, xs.length) { i => results(i) = f(xs(i)) }
    results
  }
  def parMap2[a,b](xs: Array[a], f: a => b ): Array[b] = {
    val results = new Array[b](xs.length);
    replicate(0, xs.length) { i => results(i) = f(xs(i)) }
    results
  }
  
  def replicate(start: Int, end: Int)(p: Int => Unit) {
    if (start == end) 
      ()
    else if (start + 1 == end)
      p(start)
    else {
      val mid = (start + end) / 2
      ops.par(replicate(start, mid)(p),replicate(mid, end)(p))
//      ops.spawn { replicate(start, mid)(p) }
//      replicate(mid, end)(p)
    }
  }
  
}