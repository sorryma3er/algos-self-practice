class Solution:
    # actually used two pointers thought implicitly:
    # one is i -> len(t)
    # another one is compare_idx
    def isSubsequence(self, s: str, t: str) -> bool:
        compare_idx: int = 0
        for i in range(len(t)):
            if compare_idx == len(s): return True
            if t[i] == s[compare_idx]:
                compare_idx += 1

        return True if compare_idx == len(s) else False   
   
if __name__ == "__main__":
    test: dict[tuple[str, str], bool] = {("abc","ahbgdc"): True, ("axc","ahbgdc"): False} 
    # use dict.items() extract all items in the dict
    for (key, val), flag in test.items():
        got: bool = Solution().isSubsequence(key, val)
        print(f"Got: {got} and expected: {flag}")