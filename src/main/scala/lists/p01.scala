package lists

/*
    p01: Find the last element of a list
*/

object p01 extends App {
    val title = "Pack consecutive duplicates of list elements into sublists.\n"
    
    val charList = List('a', 'b', 'b', 'c', 'c', 'c', 'e', 'e', 'e', 'e', 'f', 'g', 'h', 'i', 'j', 'j', 'j', 'k', 'k', 'l')
    val fib0to34 = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
    val l0 = List(1, 2, 3, 4, 5, 6)
    val l1 = List(0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0)

    def last[T](list: List[T]): T = list match {
        case head :: Nil => head // base case
        // move to next element by passing tail list to function recursively
        case _ :: tail => last(tail) // recurrsion occurs here
        case _ => throw new NoSuchElementException
    }
    
    print(title)
    println(f"\tGiven list of characters = ${charList}\n\tThe last element of list above = \'${p01.last(charList)}\'")

}
