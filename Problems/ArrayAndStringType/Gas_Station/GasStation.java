package ArrayAndStringType.Gas_Station;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
         * Greedy thoughts have been applied to this question, greedy is not just about caring the biggest,
         * but about it tries the earliest possible solu, and once it fails, it will jump forward past the whole failed region
         * 
         * This is greedy because at each failure, we make the locally optimal choice of skipping the failed block entirely, 
         * never reconsidering those indices. We are greedy in discarding the impossible interval as a whole.
         * 
         * Suppose you are currently testing starting point s.
         * At some index k, you find that the running tank (cumulative gas − cost from s to k) becomes negative.
         * We want to know at t where s <= t <= k, is there any t can work?
         * P(t, k) = P(s, k) - P(s, t - 1)
         * since P(s, t-1) is surely > 0 o/w it gonna stop at t-1 not t, therefore:
         * P(t, k) <= P(s, k) < 0, thus this is why we can skip invalid range at once
         */
        int total = 0;
        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++){
            tank += gas[i];
            total += gas[i];
            tank -= cost[i];
            total -= cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total < 0 ? -1 : start % gas.length;
    }
}