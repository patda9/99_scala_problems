package logic

/*
    p49: An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
            n = 1: C(1) = ("0", "1").
            n = 2: C(2) = ("00", "01", "11", "10").
            n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
        Find out the construction rules and write a function to generate Gray codes.
            scala > gray(3)
            res0: List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
*/

object p49 extends App {
    val title = "49. Gray code.\n"
    
    val bits = 3

    def gray(bits: Int): List[String] = bits match {
        case _ if(bits < 1) => List()
        case _ if(bits == 1) => List("0", "1")
        case _ => (gray(bits - 1).map(e => "0" + e)) ::: (gray(bits - 1).reverse.map(e => "1" + e))
    }
    
    println(title)
    println(f"\t${bits}-bit gray code = ${p49.gray(bits)}\n")

}