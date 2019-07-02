package arithmetic

/*
    p36: Construct a list containing the prime factors and their multiplicity.
*/

import arithmetic.p35.primeFactors
import lists.p09.pack

object p36 extends App {
    val title = "36. Construct a list containing the prime factors and their multiplicity.\n"

    val a = 315
    val b = 1200

    def primeFactorMultiplicity(x: Int): List[(Int, Int)] = {
        pack(primeFactors(x)).map(e => (e.head, e.length))
    }
    
    println(title)
    println(f"\tPrime factors multiplicity of ${a} = ${p36.primeFactorMultiplicity(a)}\n\tPrime Prime factors multiplicity of ${b} = ${p36.primeFactorMultiplicity(b)}\n")

}