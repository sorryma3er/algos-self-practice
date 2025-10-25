/*
	•	Vector：不可变、支持近似 O(1) 随机访问与尾部操作，通用首选。 既要顺序又要随机访问的不可变序列
	•	List：不可变链表，头插/模式匹配最优；随机访问/尾插慢。频繁头插/模式匹配、递归
	•	Array：可变、连续内存、O(1) 随机访问，长度固定；需要变长用 ArrayBuffer。需要原地更新的高性能场景
	•	VectorMap：不可变、保持插入顺序 的 Map；普通 Map 的迭代无序。
	•	Vector[(K,V)] 是序列，可以 indices/下标遍历；Map[K,V] 不是 0..n-1 的索引容器，不要用 size 来“按位置”取元素。

如果你把现有 Roman 表改成 VectorMap 或 Vector[(Int,String)]，两者都能保持你需要的降序遍历（Vector 要自己确保顺序；VectorMap 依靠插入顺序）。 

val table = Vector(1000 -> "M", 900 -> "CM")
Each element is a tuple created by -> (syntactic sugar for Tuple2(1000, "M")).
	•	1000 -> "M" is exactly the same as (1000, "M").

the -> you see is just a convenient way to create a tuple (Tuple2). 
A Map in Scala is constructed from a bunch of (key, value) tuples, so -> is commonly used when building maps.
*/

object Solution {
    private val romanTable: Vector[(Int, String)] = Vector(
        1000 -> "M", 900 -> "CM", 500 -> "D", 400 -> "CD", 100 -> "C", 90 -> "XC", 50 -> "L", 40 -> "XL", 10 -> "X",
        9 -> "IX", 5 -> "V", 4 -> "IV", 1 -> "I"
    )

    def intToRoman(num: Int): String = {
        val sb:StringBuilder = new StringBuilder
        var n:Int = num

        romanTable.foreach{
            case (key, value) => 
                val fac = n / key
                if (fac > 0){
                    sb.append(value * fac)
                }
                n %= key
        }

        return sb.toString()
        
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        val cases: Array[Int] = Array(1, 3, 4, 9, 58, 1287, 1994, 3999)
        cases.foreach(item => println(s"$item -> ${Solution.intToRoman(item)}"))
    }
}