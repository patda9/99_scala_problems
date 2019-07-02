package lists

/*
    p09: If a list contains repeated elements they should be placed in separate sublists.
*/

object p09 extends App {
    val title = "Pack consecutive duplicates of list elements into sublists.\n"

    val charList = List('a', 'b', 'b', 'c', 'c', 'c', 'e', 'e', 'e', 'e', 'f')

    def pack[T](list: List[T]): List[List[T]] = {
        def _pack(result: List[List[T]], remaining: List[T]): List[List[T]] = remaining match {
            case Nil => result // case 0
            case head :: tail if (result.isEmpty || result.last.head != head) => _pack(result ::: List(List(head)), tail) // case 1
            case head :: tail => _pack(result.init ::: List(result.last ::: List(head)), tail) // case 2
        }
        _pack(List(), list)
    }
    
    println(title)
    println(f"\tGiven list of characters = ${charList}\n\tList of separate sublists of duplicates = ${p09.pack(charList)}")

}
