package StackAndQueue.Remove_Duplicate_Letters_Reordering;

import java.util.*;

public class removeDupLetterReorder {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] tests = {
            "bcabc",        // expected: "abc"
            "cbacdcbc",     // expected: "acdb"
            "abcd",         // expected: "abcd" (already unique)
            "ecbacba",      // expected: "eacb" (classic case)
            "bbcaac",       // expected: "bac"
            "aaaaa",        // expected: "a"
            "zxyzzxy"       // expected: "xyz"
        };

        for (String s : tests) {
            String ans = sol.removeDuplicateLetters(s);
            System.out.println("s = \"" + s + "\" -> \"" + ans + "\"");
        }
    }
}

class Solution {
    /**
     * Monotonic Stack Classic Problem: maintian a singly increasing stack naturally solve the ordering problem
     * 
     * Given a string s, remove duplicate letters so that every letter appears once and only once. 
     * You must make sure your result is the smallest in lexicographical order among all possible results.

        Example 1:

        Input: s = "bcabc"
        Output: "abc"
        Example 2:

        Input: s = "cbacdcbc"
        Output: "acdb"
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        // use an arr to store the freq of each char
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char currChr = s.charAt(i);
            freq[currChr - 'a'] += 1;
        }

        boolean[] inStack = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        // loop to build the stack, reoder the String and guarantee no duplicate 
        for (int i = 0; i < s.length(); i++) {
            char currChr = s.charAt(i);
            int chrIdx = currChr - 'a';

            // check the char appear again after this position
            freq[chrIdx]--;

            // check in the stack?
            if (inStack[chrIdx]) continue;

            while (!stack.isEmpty()) {
                char top = stack.peek();
                int topIdx = top - 'a';

                // int val of currChar < top char && top char gonna appear again later, we are safe
                // to move the currChar infront
                if (currChr < top && freq[topIdx] > 0){
                    stack.pop();
                    inStack[topIdx] = false;
                } else {
                    break;
                }
            }

            stack.push(currChr);
            inStack[chrIdx] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
