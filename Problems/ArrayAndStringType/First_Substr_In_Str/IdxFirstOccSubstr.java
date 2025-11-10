package ArrayAndStringType.First_Substr_In_Str;

public class IdxFirstOccSubstr {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(sol.strStr(haystack, needle));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++){
            char currChr = haystack.charAt(i);
            if (needle.charAt(0) == currChr) {
                int currIdx = i;
                int matchedLen = 1;
                for (int j = 1; j < needle.length(); j++){
                    if (++currIdx == haystack.length()) break;

                    if (needle.charAt(j) != haystack.charAt(currIdx)) break;
                    else {
                        matchedLen++;
                    }
                }
                if (matchedLen == needle.length()) return i;
            }
        }
        return -1;
    }
}