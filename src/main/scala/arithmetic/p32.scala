package arithmetic

/*
    p32: Use Euclid's algorithm.
*/

object p32 extends App {
    val title = "32. Determine the greatest common divisor of two positive integer numbers.\n"

    val a = 36
    val b = 63

    def gcd(x: Int, y: Int): Int = {
        if(y == 0) x
        else gcd(y, x % y)
    }

    println(title)
    println(f"\tgcd(${a}, ${b}) = ${p32.gcd(a, b)}\n")

}