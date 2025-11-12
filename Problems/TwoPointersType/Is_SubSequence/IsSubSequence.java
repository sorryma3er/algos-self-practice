package TwoPointersType.Is_SubSequence;


public class IsSubSequence {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int compareIdx = 0;
        if (s.length() == 0) return true;

        for (int i = 0; i < t.length(); i++){
            if (compareIdx == s.length()) return true;
            if (s.charAt(compareIdx) == t.charAt(i)) compareIdx++;
        }
        return compareIdx == s.length();
    }
}
