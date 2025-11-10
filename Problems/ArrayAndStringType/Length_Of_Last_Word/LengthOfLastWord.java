package ArrayAndStringType.Length_Of_Last_Word;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }
}

public class LengthOfLastWord{
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("   fly me   to   the moon  "));
    }
}

