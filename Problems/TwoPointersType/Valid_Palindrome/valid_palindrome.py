class Solution:
    def isPalindrome(self, s: str) -> bool:
        front_idx:int = 0
        end_idx:int = len(s) - 1

        while (front_idx < end_idx):
            front:str = s[front_idx]
            end:str = s[end_idx]

            if not front.isalnum():
                front_idx += 1
                continue
            elif not end.isalnum():
                end_idx -= 1
                continue
            
            if front.upper() != end.upper(): return False

            front_idx += 1
            end_idx -= 1

        return True

if __name__ == "__main__":
    test: list[str] = ["A man, a plan, a canal: Panama", "race a car", " ", "0P"]
    expect: list[bool] = [True, False, True, False]
    passed_count: int = 0
    
    for i in range(len(test)):
        res_flag:bool = Solution().isPalindrome(test[i])
        varify:bool = res_flag == expect[i]
        
        # python way ternary conditional expression
        pass_state:str = "PASS ✅" if varify else "FAIL ❌"
        
        passed_count += 1 if varify == True else 0
        print(f"[Case {i + 1}]\nInput: {test[i]}\nExpected: {expect[i]}\nGot: {varify}\nResult: {pass_state}\n")
    
    print(f"Summary: {passed_count}/{len(test)} test cases passed.")