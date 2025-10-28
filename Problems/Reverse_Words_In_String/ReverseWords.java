package Reverse_Words_In_String;
import java.util.Collections;
import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(new Solution().reverseWords(s));
    }
    
}

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // remember the \\s+ is for split on one-or-more whitespace characters
        Collections.reverse(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i != words.length - 1){
                sb.append(words[i] + " ");
            }
            else {
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }
}