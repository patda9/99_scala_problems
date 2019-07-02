package arithmetic

/*
    p34: Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
*/

import arithmetic.p32.gcd

object p34 extends App {
    val title = "34. Calculate Euler's totient function phi(m).\n"

    val a = 10
    val b = 10090

    def totient(x: Int): Int = {
        (1 to x).filter(gcd(x, _) == 1).length
    }
    
    println(title)
    println(f"\tphi(${a}) = ${p34.totient(a)}\n\tphi(${a}) = ${p34.totient(b)}\n")
}