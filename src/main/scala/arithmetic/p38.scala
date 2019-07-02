package arithmetic

/*
    p36: Use the solutions of problems P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example.
*/

import arithmetic.p34.totient
import arithmetic.p37.phi

object p38 extends App {
    val title = "38. Compare the two methods of calculating Euler's totient function.\n"

    val a = 10
    val b = 10090

    def comparePhi(m: Int): Boolean = {
        val res1 = totient(m)
        val res2 = phi(m)
        res1 == res2
    }
    
    println(title)
    println(f"\t<totient(Int)> phi(${a}) = ${totient(a)}\n\t<phi(Int)> phi(${a}) = ${phi(a)}")
    println(f"\t<totient(Int)> phi(${a}) == <phi(Int)> phi(${a}): ${comparePhi(10090)}\n")

}