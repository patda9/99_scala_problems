package logic
import scala.concurrent.ExecutionContext.Implicits

/*
    p47: Continue problem P46 by redefining and, or, etc as operators.
            (i.e. make them methods of a new class with an implicit conversion from Boolean.)
            not will have to be left as a object method.
                scala > table2((a: Boolean, b: Boolean) => a and (a or not(b)))
*/

object p47 extends App {
    implicit class BooleanWrapper(a: Boolean) {
        def and(b: => Boolean): Boolean = a && b
        def or(b: => Boolean): Boolean = a || b
        def nand(b: => Boolean): Boolean = !(a && b)
        def nor(b: => Boolean): Boolean = !(a || b)
        def xor(b: => Boolean): Boolean = a != b
        def impl(b: => Boolean): Boolean = if(a) b else true
        def equ(b: => Boolean): Boolean = a == b
    }

    println("Problem[47]")
    
}