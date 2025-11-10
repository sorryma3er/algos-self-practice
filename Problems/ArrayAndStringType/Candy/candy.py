"""
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
"""
from typing import List

def candy(ratings: List[int]) -> int:
        result: List[int] = [1] * len(ratings)

        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                result[i] = result[i - 1] + 1
        
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                result[i] = max(result[i + 1] + 1, result[i])

        total = 0
        for item in result:
            total += item
        
        return total
    
if __name__ == "__main__":
    ratings: List[int] = [1,2,87,87,87,2,1]
    
    print(candy(ratings=ratings))