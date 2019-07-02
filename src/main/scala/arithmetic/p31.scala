package arithmetic

/*
    p31: Check whether integer is prime or not.  
*/

object p31 extends App { 
    val title = "31. Determine whether a given integer number is prime.\n"

    val a = 11
    val b = 347

    def isPrime(x: Int): Boolean = {
        if(x < 2) false // find all its factors from 2 to sqrt(itself)
        else !((2 to Math.sqrt(x).toInt) exists (x % _ == 0))
    }

    println(title)
    println(f"\t${a}\tis\tprime:\t${p31.isPrime(11)}\n\t${b}\tis\tprime:\t${p31.isPrime(347)}\n")

}