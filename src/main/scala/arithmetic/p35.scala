package arithmetic

/*
    p35: Construct a flat list containing the prime factors in ascending order.
*/

import arithmetic.p31.isPrime

object p35 extends App {
    val title = "35. Determine the prime factors of a given positive integer.\n"

    val a = 315
    val b = 1200

    def primeFactors(x: Int): List[Int] = {
        def _isPrimeAndRational(a: Int, b: Int): Boolean = {
            isPrime(a) && (b % a == 0)
        }
            
        def _primeFactors(result: List[Int], remaining: (List[Int], Int)): List[Int] = remaining match {
                case (_, 1) => result
                case (head :: tail, q) if(q % head == 0) => _primeFactors(result ::: List(head), (head :: tail, q / head)) // return (quotient / factor)
                case (head :: tail, q) => _primeFactors(result, (tail, q)) 
        }

        _primeFactors(List(), ((2 to x).filter(_isPrimeAndRational(_, x)).toList, x))

    }
    
    println(title)
    println(f"\tPrime factors of ${a} = ${p35.primeFactors(a)}\n\tPrime factors of ${b} = ${p35.primeFactors(b)}\n")

}