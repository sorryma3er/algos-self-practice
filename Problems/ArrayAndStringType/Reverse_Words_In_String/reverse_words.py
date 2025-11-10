class Solution:
    def reverseWords(self, s: str) -> str:
        words: list[str] = s.split(" ")
        filtered_words: list[str] = list(filter(lambda word: word != "", words))
        filtered_words.reverse() # change in-place, returning None
        # reversed_words = reversed(filtered_words)
        reversed_str = " ".join(filtered_words) # " " is 连接符 between each elt in iterable
        return reversed_str
    
if __name__ == "__main__":
    s: str = "a goood     example"
    print(Solution().reverseWords(s))