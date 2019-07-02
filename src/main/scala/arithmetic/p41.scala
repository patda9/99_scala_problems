package arithmetic

/*
 p41: Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
            scala > printGoldbachList(9 to 20)
                10 = 3 + 7
                12 = 5 + 7
                14 = 3 + 11
                16 = 3 + 13
                18 = 5 + 13
                20 = 3 + 17
        In most cases, if an even number is written as the sum of two prime numbers, one of them is very small.
        Very rarely, the primes are both bigger than, say, 50.
        Try to find out how many such cases there are in the range 2..3000.
            Example (minimum value of 50 for the primes):
                scala > printGoldbachListLimited(1 to 2000, 50)
                992 = 73 + 919
                1382 = 61 + 1321
                1856 = 67 + 1789
                1928 = 61 + 1867

*/

import arithmetic.p39.listPrimeRange

object p41 extends App {
    val title = "41. A list of Goldbach compositions.\n"

    val start = 9
    val inclusiveStop = 20
    val minPrimeVal = 5

    def printGoldbachListLimited(r: Range, min: Int = 3): Unit = {
        val primes = min match {
            case min if(min < 3) => listPrimeRange(3 to r.toList.last)
            case min => listPrimeRange(min to r.toList.last)
        }
        def _goldbachList(result: List[(Int, Int, Int)], remaining: List[Int]): List[(Int, Int, Int)] = {
            remaining match {
                case head :: tail if(tail == Nil) => result
                case head :: tail => _goldbachList(result ::: tail.map(e => (head, e, e + head))
                .filter(e => e._3 % 2  == 0 && e._3 <= r.toList.last), tail)
            }
        }
        val finalResult = _goldbachList(List(), primes).distinct.sorted
        finalResult.map(e => printf(f"\t\t${e._1} + ${e._2} = ${e._3}\n"))
    }

    println(title)
    println(f"\tGoldbach's conjecture list with minimum\n\tprime value ${minPrimeVal} (default is 3) = {")
    printGoldbachListLimited(start to inclusiveStop)
    println("\t}\n")

}
