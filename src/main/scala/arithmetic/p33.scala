package arithmetic

/*
    p33: Two numbers are coprime if their greatest common divisor equals 1.
*/

import arithmetic.p32.gcd

object p33 extends App {
    val title = "33. Determine whether two positive integer numbers are relatively prime.\n"

    val a = 35
    val b = 64

    def areRelativelyPrime(x: Int, y: Int): Boolean = {
        gcd(x, y) == 1
    }

    println(title)
    println(f"\t${a} and ${b} are relatively prime: ${p33.areRelativelyPrime(a, b)}\n")

}