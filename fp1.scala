// GENERATED
/* INSTRUCTIONS
 *
 * Complete the exercises below.  For each "EXERCISE" comment, add
 * code immediately below the comment.
 *
 * Please see README.md for instructions, including compilation and testing.
 * 
 * GRADING
 * 
 * 1. Submissions MUST compile using SBT with UNCHANGED configuration and tests with no
 *    compilation errors.  Submissions with compilation errors will receive 0 points.
 *    Note that refactoring the code will cause the tests to fail.
 *
 * 2. You MUST NOT edit the SBT configuration and tests.  Altering it in your submission will
 *    result in 0 points for this assignment.
 *
 * 3. You MUST NOT use while loops or (re)assignment to variables (you can use "val" declarations,
 *    but not "var" declarations).  You must use recursion instead.
 *
 * 4. You may declare auxiliary functions if you like.
 *
 * SUBMISSION
 *
 * 1. Submit this file on D2L before the deadline.
 *
 * 2. Late submissions will not be permitted because solutions will be discussed in class.
 * 
 */

import scala.collection.mutable.ListBuffer

object fp1 {

  // EXAMPLE: here is the definition of the factorial function.
  def fact (n : Int) : Int = {
    if (n <= 1) 
      1
    else 
      n * fact (n - 1)
  }
  // Note that the fact computes as follows (leaving out some steps):
  //
  // fact (5)
  // --> if (5 <= 1) 1 else 5 * fact (5 - 1)
  // --> if (false) 1 else 5 * fact (5 - 1)
  // --> 5 * fact (5 - 1)
  // --> 5 * fact (4)
  // --> 5 * (if (4 <= 1) 1 else 4 * fact (4 - 1))
  // --> 5 * (4 * fact (3))
  // --> 5 * (4 * (3 * fact (2))
  // --> 5 * (4 * (3 * (2 * fact (1)))
  // --> 5 * (4 * (3 * (2 * (if (1 <= 1) 1 else 1 * fact (1 - 1)))))
  // --> 5 * (4 * (3 * (2 * (if (true) 1 else 1 * fact (1 - 1)))))
  // --> 5 * (4 * (3 * (2 * 1)))
  // --> 5 * (4 * (3 * 2))
  // --> 5 * (4 * 6)
  // --> 5 * 24
  // --> 120
  //
  // We can get the same answer with less work by starting at the base case and computing up:
  //
  // fact (1) --> 1
  // fact (2) --> 2 * fact (1) --> 2 * 1 --> 2
  // fact (3) --> 3 * fact (2) --> 3 * 2 --> 6
  // fact (4) --> 4 * fact (3) --> 4 * 6 --> 14
  // fact (5) --> 5 * fact (4) --> 5 * 24 --> 120

  // EXERCISE 1: complete the following definition, so that factTest is the list of integers
  // List(1,2,6,24,120).  You must call the "fact" function (five times) defined above instead of
  // hardcoding the numbers 1,2,6,24,120.
  val factTest : List[Int] = {
    
    var numbers = new ListBuffer[Int]()
 
    for(n <- 1 to 5){
      numbers += fact(n)
    }    
    
    val ans = numbers.toList
    ans
  }

  // EXERCISE 2: complete the following definition of the Fibonacci function.
  def fib (n : Int) : Int = n match{
    // TODO: Provide definition here.
    
    case 0|1 => n
    case _=> fib(n-1) + fib(n-2)
  }

  
  // EXERCISE 3: declare the identifier "p1" with a pair consisting of the Int 7 and the String
  // "hello"
  val p1 : (Int, String) = {
    // TODO: Provide definition here.  
    (7, "hello")
  }

  // EXERCISE 4: declare the identifier "t1" with a triple consisting of the Int 7, the String
  // "hello", and the Boolean false
  val t1 : (Int, String, Boolean) = {
    // TODO: Provide definition here.
    (7, "hello", false)
  }

  // EXERCISE 5: write a function "swap" that takes a pair of an Int and a String, and returns a
  // pair of a String and an Int (with the values from the pair passed an argument.  E.g., swap (p1)
  // should return ("hello", 7).  You can use "p._1" and "p._2" to access the first and second
  // components of a pair.
  def swap (p:(Int,String)) : (String,Int) = {
    // TODO: Provide definition here.
    
    (p._2, p._1)
  }

  // EXERCISE 6: write a function "sum" that takes a list of integers and sums them.  As with all of
  // the exercises in this assignment, your function MUST be recursive and MUST NOT use a while
  // loop.
  def sum (xs : List[Int]) : Int = xs match{

    case Nil =>0
    case x::xs => x + sum(xs)
  }


  // EXERCISE 7: given the definition of the function "sumTailAux" below, complete the
  // definition of the function "sumTail" so that it also sums a list of integers.  You
  // must not alter the definition of "sumTailAux".  Your definition for "sumTail"
  // must call "sumTailAux" directly, and must not call "sum"
  def sumTailAux (accumulator : Int, xs : List[Int]) : Int = {
    xs match {
      case Nil => accumulator
      case y::ys => sumTailAux (accumulator + y, ys)
    }
  }

  def sumTail (xs : List[Int]) : Int = {
    // TODO: Provide definition here.
    
    sumTailAux(0, xs)
  }


  // EXERCISE 8: complete the following definition of the function "max" that finds the maximum
  // integer in a list of integers.  Note that no value can be returned when the list is empty,
  // hence the "NoSuchElementException".  Your function MUST be recursive and MUST NOT use a while
  // loop.  You MUST NOT use the "max" method on lists, but can use the "max" method on integers.
  def max (xs : List[Int]) : Int = xs match{
    
    case Nil => throw new NoSuchElementException("Empty List")
    case y::Nil => y
    case y::ys => val m = max(ys)
                  if(m>y) m
             
                  else y
                  
  }

  // EXERCISE 9: given the definition of the function "maxTail" below, complete the
  // definition of the function "maxTailAux" so that "maxTail" also finds the
  // maximum of a list of integers.  You must not alter the definition of "maxTail".  Your
  // definition for "maxTailAux" must be recursive and not use while loops.
  def maxTailAux (accumulator : Int, xs : List[Int]) : Int = {
    if(xs.isEmpty) {accumulator}
    else if (xs.head > accumulator){ maxTailAux(xs.head,xs.tail)}
    else { maxTailAux(accumulator,xs.tail)}
  }

  def maxTail (xs : List[Int]) : Int = {
    xs match {
      case Nil => throw new java.util.NoSuchElementException
      case y::ys => maxTailAux (y, ys)
    }
  }

  // EXERCISE 10: Write a recursive function "otpu" ("upto" backwards) that takes two Int parameters
  // "start" and "end" and produces a "List[Int]" that counts DOWN from "start" to "end" (inclusive
  // at both ends) one at a time.  If "start < end", the empty list must be returned.
  def otpu (start : Int, end : Int) : List[Int] = {    
    if(start>=end) start :: otpu(start-1,end)
    else List()
  }
}

