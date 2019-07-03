package logic

/*
    p50: First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!
            We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
                E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)). 
            Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.
                scala > huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
                res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
*/

import scala.collection.mutable.ListBuffer

object p50 extends App {
    val title = "50. Huffman code.\n"

    val data = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))

    def huffman(data: List[(String, Int)]): List[(String, String)] = {
        class Node(s: String="", f: Int=0, left: Node=null, right: Node=null) {
            val _s = s
            val _f = f
            var _left = left
            var _right = right
        }

        val nodes = data.sortBy(_._2).map(n => new Node(n._1, n._2))

        def _constructTree(tree: List[Node], queue: List[Node]): List[Node] = queue match {
            case head :: tail if(tail == Nil) => tree
            case h1 :: h2 :: tail if(queue.length > 2) => {
                val temp = (tail ::: List(new Node(s="-", f=h1._f + h2._f, left=h1, right=h2))).sortBy(_._f)
                _constructTree(temp, temp)
            }
            case h1 :: h2 :: tail => {
                val temp = (tail ::: List(new Node(s="root", f=h1._f + h2._f, left=h1, right=h2))).sortBy(_._f)
                _constructTree(temp, temp)
            }
        }

        val root = _constructTree(List(), nodes)(0)
        val result: ListBuffer[(String, String)] = ListBuffer()

        def _listHuffmanCode(n: Node, s: String): ListBuffer[(String, String)] = {
            if(!(n._left == null && n._right == null && n._s != "root")) {
                _listHuffmanCode(n._left, s + "0")
                _listHuffmanCode(n._right, s + "1")
            }
            else result += ((n._s, s))
        }
        _listHuffmanCode(root, "").toList.sortBy(_._1)
    }

    println(title)
    println(f"\tOriginal (symbol, frequency) pairs = ${data}")
    println(f"\tHuffman encoding result = ${p50.huffman(data)}\n")

}
