object Solution {
    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
        var total = 0
        var tank = 0
        var start = 0

        for (i <- 0 until gas.length){
            val diff = gas(i) - cost(i)
            total += diff
            tank += diff

            if (tank < 0){
                start = i + 1
                tank = 0
            }
        }

        if (total < 0) -1 else start % gas.length
    }
}

object Main{
    def main(args: Array[String]): Unit = {
        val gas  = Array(1, 2, 3, 4, 5)
        val cost = Array(3, 4, 5, 1, 2)
        println(Solution.canCompleteCircuit(gas, cost))
    }
}