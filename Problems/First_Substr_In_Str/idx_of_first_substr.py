class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        for i in range(len(haystack)):
            if haystack[i] == needle[0]:
                matched_len: int = 1
                for j in range(1, len(needle)):
                    if i + j >= len(haystack): break
                    if haystack[i + j] == needle[j]: matched_len += 1
                    else: break
                
                if matched_len == len(needle): return i
        
        return -1
    
if __name__ == "__main__":
    haystack: str = "hello"
    needle: str = "ll"
    print(Solution().strStr(haystack, needle))