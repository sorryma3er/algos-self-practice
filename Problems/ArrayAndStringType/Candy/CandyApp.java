package ArrayAndStringType.Candy;

import java.util.Arrays;

/*
 * 
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */

public class CandyApp {

    public static void main(String[] args) {

        System.out.println(new Solution().Candy(new int[]{1,2,87,87,87,2,1}));
    }
}

class Solution {
    public int Candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);

        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i - 1]){
                result[i] = result[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]){
                result[i] = Math.max(result[i + 1] + 1, result[i]);
            }
        }

        int ret = 0;
        for (int i = 0; i < ratings.length; i++){
            //System.out.println(result[i]);
            ret += result[i];
        }
        return ret;
    }
}