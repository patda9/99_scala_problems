package arithmetic

/*
    p39: Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
*/

import arithmetic.p31.isPrime

object p39 extends App {
    val title = "39. A list of prime numbers.\n"

    val start = 7
    val inclusiveStop = 31

    def listPrimeRange(r: Range): List[Int] = {
        r.toList.filter(isPrime(_))
    }
    
    println(title)
    println(f"\tPrime numbers in range ${start} to ${inclusiveStop} = ${p39.listPrimeRange(start to inclusiveStop)}\n")

}
