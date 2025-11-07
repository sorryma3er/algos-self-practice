from typing import List

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        curr_idx: int = 0
        ret_lst: List[str] = []
        while curr_idx < len(words):
            curr_lst: List[str] = [words[curr_idx]]
            curr_len = len(words[curr_idx])
            next_idx = curr_idx + 1
        
            # greedy finding the maximum words can take in one line & determine next_idx of next line
            while next_idx < len(words) and curr_len + 1 + len(words[next_idx]) <= maxWidth:
                curr_len += len(words[next_idx]) + 1
                curr_lst.append(' ')
                curr_lst.append(words[next_idx])
                next_idx += 1
                
            is_last_line: bool = next_idx == len(words)
            if is_last_line:
                # deal with left justification for last line, continue to prevent run the rest codes
                s = ''.join(curr_lst)
                s += ' ' * (maxWidth - curr_len)
                ret_lst.append(s)
                curr_idx = next_idx
                continue
                
            # deal with only one word forming a line --- also left justification
            if len(curr_lst) == 1 and curr_len + 1 <= maxWidth:
                curr_lst.append(' ') # append one space so the leftover spaces have place to go
                curr_len += 1
                
            spaces = maxWidth - curr_len
            while spaces > 0:
                for i in range(len(curr_lst)):
                    curr_str = curr_lst[i]
                    if curr_str[0] == ' ' and spaces > 0:
                        curr_lst[i] = curr_str + ' '
                        spaces -= 1

            s = ''.join(curr_lst)
            ret_lst.append(s)
            
            # update curr_idx
            curr_idx = next_idx
        
        return ret_lst
            
if __name__ == "__main__":
    words_lst: List[List[str]] = [
        ["This", "is", "an", "example", "of", "text", "justification."],
        ["What","must","be","acknowledgment","shall","be"], 
        ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"],
        ["Listen","to","many,","speak","to","a","few."]
    ]
    max_width_lst: List[int] = [16, 16, 20, 6]

    #test = zip(words_lst, max_width_lst) this is just an obj, not a list
    test: List[tuple[List[str], int]] = list(zip(words_lst, max_width_lst))
    
    for lst, max_width in test:
        print("Input list is", lst, "Max length of one line is", max_width)
        print(Solution().fullJustify(lst, max_width))