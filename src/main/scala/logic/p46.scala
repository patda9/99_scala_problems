package logic

/*
    p46: 
*/

object p46 extends App {
    def and(a: Boolean, b: Boolean): Boolean = {
        a && b
    }

    def or(a: Boolean, b: Boolean): Boolean = {
        a || b
    }

    def nand(a: Boolean, b: Boolean): Boolean = {
        !(a && b)
    }

    def nor(a: Boolean, b: Boolean): Boolean = {
        !(a || b)
    }

    /* use universal gate in implementation */
    def xor(a: Boolean, b: Boolean): Boolean = {
        nand(nand(a, nand(a, b)), nand(b, nand(a, b)))
    }

    def impl(a: Boolean, b: Boolean): Boolean = {
        nand(nand(nand(a, a), nand(a, a)), nand(b, b))
    }

    def equ(a: Boolean, b: Boolean): Boolean = {
        nand(xor(a, b), true)
    }

    def printTruthTable(f: (Boolean, Boolean) => Boolean): Unit = {
        val t = true
        val results = List(f(!t, !t), f(!t, t), f(t, !t), f(t, t))
        println("A\tB\tResult\nfalse\tfalse\t%s\nfalse\ttrue\t%s\ntrue\tfalse\t%s\ntrue\ttrue\t%s".format(results:_*))
    }

    printTruthTable(and)
    printTruthTable(or)
    printTruthTable(nand)
    printTruthTable(nor)
    printTruthTable(xor)
    printTruthTable(impl)
    printTruthTable(equ)

}