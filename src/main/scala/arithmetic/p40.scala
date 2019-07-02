package arithmetic

/*
    p40: Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
            E.g. 28 = 5 + 23.
        It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
        It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
        Write a function to find the two prime numbers that sum up to a given even integer.
*/

import arithmetic.p39.listPrimeRange

object p40 extends App {
    val title = "40. Goldbach's conjecture.\n"

    val a = 28

    def goldbach(x: Int): (Int, Int) = {
        val primes = listPrimeRange(3 to x)
        (primes(primes.map(e => e + primes.last).indexOf(x)), primes.last)
    }
    
    val temp = goldbach(a)
    
    println(title)
    println(f"\tGoldbach's conjecture of ${a} = ${temp._1} + ${temp._2} ; ${temp}\n")

}
