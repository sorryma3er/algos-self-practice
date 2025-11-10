package ArrayAndStringType.Longest_Common_Prefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestCommonPrefix(new String[] {"aaa", "aa", "aaa"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String target = strs[0];
        int idx = 1;

        while (target.length() > 0 && idx < strs.length){
            String toComapre = strs[idx];
            if (toComapre.length() == 0) return "";
            for (int j = 0; j < toComapre.length() && j < target.length(); j++){
                if (target.charAt(j) != toComapre.charAt(j)) {
                    target = target.substring(0, j);
                    System.out.println(target);
                    break;
                }
                else if (target.charAt(j) == toComapre.charAt(j) && j == toComapre.length() - 1){
                    target = target.substring(0, j + 1);
                }
            }
            idx++;
        }

        return target;
    }
}