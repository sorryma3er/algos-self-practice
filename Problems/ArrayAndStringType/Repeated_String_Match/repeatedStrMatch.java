package ArrayAndStringType.Repeated_String_Match;

public class repeatedStrMatch {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // a = "abcd", b = "cdabcdab"
        // "abcd" repeated 3 times => "abcdabcdabcd" contains "cdabcdab"
        String a1 = "abcd";
        String b1 = "cdabcdab";
        int ans1 = sol.repeatedStringMatch(a1, b1);
        System.out.println("Test 1:");
        System.out.println("  a = " + a1);
        System.out.println("  b = " + b1);
        System.out.println("  result = " + ans1);
        System.out.println("  expect = 3");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // a = "a", b = "aa"
        // "a" repeated 2 times => "aa"
        String a2 = "a";
        String b2 = "aa";
        int ans2 = sol.repeatedStringMatch(a2, b2);
        System.out.println("Test 2:");
        System.out.println("  a = " + a2);
        System.out.println("  b = " + b2);
        System.out.println("  result = " + ans2);
        System.out.println("  expect = 2");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // a = "abc", b = "cabcabca"
        // "abc" repeated 4 times => "abcabcabcabc" contains b
        String a3 = "abc";
        String b3 = "cabcabca";
        int ans3 = sol.repeatedStringMatch(a3, b3);
        System.out.println("Test 3:");
        System.out.println("  a = " + a3);
        System.out.println("  b = " + b3);
        System.out.println("  result = " + ans3);
        System.out.println("  expect = 4");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // impossible case
        // a = "ab", b = "bababaX" (contains 'X' not in a)
        String a4 = "ab";
        String b4 = "bababaX";
        int ans4 = sol.repeatedStringMatch(a4, b4);
        System.out.println("Test 4:");
        System.out.println("  a = " + a4);
        System.out.println("  b = " + b4);
        System.out.println("  result = " + ans4);
        System.out.println("  expect = -1");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 5 ----------------------
        // b is already in a
        // a = "hello", b = "ell" => 1
        String a5 = "hello";
        String b5 = "ell";
        int ans5 = sol.repeatedStringMatch(a5, b5);
        System.out.println("Test 5:");
        System.out.println("  a = " + a5);
        System.out.println("  b = " + b5);
        System.out.println("  result = " + ans5);
        System.out.println("  expect = 1");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int lenA = a.length() ,lenB = b.length();
        String temp = "";
        int count = 0;

        while (temp.length() <= lenB + (lenA - 1) * 2) {
            temp += a;
            count++;
            if (temp.length() < lenB) continue;
            else if (temp.contains(b)) return count;
        }
        return -1;
    }
}
