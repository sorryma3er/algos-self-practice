package StackAndQueue.Heap.Max_Num_Eaten_Apple;

import java.util.*;

public class maxNumEatenApples {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // LeetCode 常见样例（结果应为 7）
        int[] apples1 = {1, 2, 3, 5, 2};
        int[] days1   = {3, 2, 1, 4, 2};
        int ans1 = sol.eatenApples(apples1, days1);

        System.out.println("Test 1:");
        System.out.println("  apples = " + Arrays.toString(apples1));
        System.out.println("  days   = " + Arrays.toString(days1));
        System.out.println("  result = " + ans1);
        System.out.println("  expect = 7");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // LeetCode 样例：结果应为 5
        int[] apples2 = {3, 0, 0, 0, 0, 2};
        int[] days2   = {3, 0, 0, 0, 0, 2};
        int ans2 = sol.eatenApples(apples2, days2);

        System.out.println("Test 2:");
        System.out.println("  apples = " + Arrays.toString(apples2));
        System.out.println("  days   = " + Arrays.toString(days2));
        System.out.println("  result = " + ans2);
        System.out.println("  expect = 5");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // 全部立即腐烂（days 全是 0）=> 结果应为 0
        int[] apples3 = {2, 1, 10};
        int[] days3   = {0, 0, 0};
        int ans3 = sol.eatenApples(apples3, days3);

        System.out.println("Test 3:");
        System.out.println("  apples = " + Arrays.toString(apples3));
        System.out.println("  days   = " + Arrays.toString(days3));
        System.out.println("  result = " + ans3);
        System.out.println("  expect = 0");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // 单天大量苹果但保质期长，可以吃很久（结果应为 10）
        int[] apples4 = {10};
        int[] days4   = {100};
        int ans4 = sol.eatenApples(apples4, days4);

        System.out.println("Test 4:");
        System.out.println("  apples = " + Arrays.toString(apples4));
        System.out.println("  days   = " + Arrays.toString(days4));
        System.out.println("  result = " + ans4);
        System.out.println("  expect = 10");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 5 ----------------------
        // 每天 1 个，且第二天就腐烂（days=1），只能当天吃 => 结果应为 n
        int[] apples5 = {1, 1, 1, 1};
        int[] days5   = {1, 1, 1, 1};
        int ans5 = sol.eatenApples(apples5, days5);

        System.out.println("Test 5:");
        System.out.println("  apples = " + Arrays.toString(apples5));
        System.out.println("  days   = " + Arrays.toString(days5));
        System.out.println("  result = " + ans5);
        System.out.println("  expect = 4");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int day = 0;
        int n = apples.length;
        int eaten = 0;
        
        while (day < n || !pq.isEmpty()) {
            // decide whether enqueue today: [expire, #apples]
            if (day < n && apples[day] > 0 && days[day] > 0) {
                int expire = day + days[day];
                pq.offer(new int[]{ expire, apples[day] });
            }

            // remove apples are expired
            while (!pq.isEmpty() && pq.peek()[0] <= day) pq.poll();

            // at this point if the queue is not empty, apples can be consumed
            if (!pq.isEmpty()) {
                int[] top = pq.poll();

                // consume one
                top[1]--;
                eaten++;
                
                if (top[1] > 0) pq.offer(top);
            }

            day++;
        }
        return eaten;
    }
}
