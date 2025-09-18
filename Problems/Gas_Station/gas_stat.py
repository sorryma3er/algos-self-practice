from typing import List

def canCompleteCircuit(gas: List[int], cost: List[int]) -> int:
        total:int = 0
        tank = 0
        start = 0

        for i in range(len(gas)):
            diff = gas[i] - cost[i]
            total += diff
            tank += diff

            if tank < 0:
                start = i + 1
                tank = 0
        
        return -1 if total < 0 else start % len(gas)
    
if __name__ == "__main__":
    gas: List[int] = [1,2,3,4,5]
    cost: List[int] = [3,4,5,1,2]
    
    print(canCompleteCircuit(gas, cost))

        