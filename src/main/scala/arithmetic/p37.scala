package arithmetic

/*
    p36: See problem P34 for the definition of Euler's totient function. If the list of the prime factors of a number m is
        known in the form of problem P36 then the function phi(m>) can be efficiently calculated as follows:
            Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their multiplicities) of a given number m.
        Then phi(m) can be calculated with the following formula:
            phi(m) = (p1-1)*p1^(m1-1) * (p2-1)*p2^(m2-1) * (p3-1)*p3^(m3-1) * ...
*/

import arithmetic.p34.totient
import arithmetic.p36.primeFactorMultiplicity

object p37 extends App {
    val title = "37. Calculate Euler's totient function phi(m) (improved).\n"

    val a = 10
    val b = 10090

    def phi(m: Int): Int = {
        primeFactorMultiplicity(m).map(e => (e._1 - 1) * Math.pow(e._1, e._2 - 1).toInt).fold(1)(_*_)
    }
    
    println(title)
    println(f"\tphi(${a}) = ${p37.phi(a)}\n\tphi(${a}) = ${p37.phi(b)}\n")

}