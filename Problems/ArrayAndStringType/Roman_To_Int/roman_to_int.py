class Solution:
    def romanToInt(self, s: str) -> int:
        roman_dict: dict[str, int] = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1}
        
        prev = 0 # keep a ref to the prev, since once we reversed the seq, the substraction will take place when the prev > curr
        
        reverse_s = reversed(s)
        total = 0
        
        for c in reverse_s:
            curr = roman_dict[c] # get the val
            if prev > curr:
                total -= curr
            else:
                total += curr
                
            prev = curr
        
        return total
    
if __name__ == "__main__":
    s = 'MMDLXXXIX'
    print(Solution().romanToInt(s))
                
        