class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # target: list[list[str]] = [[] * numRows] wrong since multiply doesnt mean any thing ---> resulting [[]]
        target: list[list[str]] = [[] for _ in range(numRows)]
        # even we initialize it, but we still cannot access like target[0][0] since its not exist yet, unless we initialize them
        print(target)

        idx_row: int = 0
        reverse: bool = False
        for char in s:
            if idx_row < numRows - 1 and not reverse:
                target[idx_row].append(char)
                idx_row += 1
            elif idx_row == numRows - 1 and not reverse:
                target[idx_row].append(char)
                reverse = not reverse
                idx_row -= 1
            elif idx_row > 0 and reverse:
                target[idx_row].append(char)
                idx_row -= 1
            elif idx_row == 0 and reverse:
                target[idx_row].append(char)
                reverse = not reverse
                idx_row += 1

        print(target)
        
        ret: str = ""
        for sub_lst in target:
            for elt in sub_lst:
                ret += elt
                
        
        return ret
        
        
if __name__ == "__main__":
    s: str = "PAYPALISHIRING"
    rows: int = 4
    print(Solution().convert(s, rows))