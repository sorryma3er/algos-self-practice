package ArrayAndStringType.String_Formatting;

public class strFormat {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        String s1 = "5F3Z-2e-9-w";
        int k1 = 4;
        System.out.println("Test 1:");
        System.out.println("  s      = " + s1);
        System.out.println("  k      = " + k1);
        System.out.println("  result = " + sol.licenseKeyFormatting(s1, k1));
        System.out.println("  expect = 5F3Z-2E9W");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        String s2 = "2-5g-3-J";
        int k2 = 2;
        System.out.println("Test 2:");
        System.out.println("  s      = " + s2);
        System.out.println("  k      = " + k2);
        System.out.println("  result = " + sol.licenseKeyFormatting(s2, k2));
        System.out.println("  expect = 2-5G-3J");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // Many dashes, mixed case
        String s3 = "---a--bC---d---";
        int k3 = 2;
        System.out.println("Test 3:");
        System.out.println("  s      = " + s3);
        System.out.println("  k      = " + k3);
        System.out.println("  result = " + sol.licenseKeyFormatting(s3, k3));
        System.out.println("  expect = A-B C-D (=> actually \"AB-CD\")");
        System.out.println("  expect = AB-CD");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // k = 1 (every char separated)
        String s4 = "a-b-c";
        int k4 = 1;
        System.out.println("Test 4:");
        System.out.println("  s      = " + s4);
        System.out.println("  k      = " + k4);
        System.out.println("  result = " + sol.licenseKeyFormatting(s4, k4));
        System.out.println("  expect = A-B-C");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 5 ----------------------
        // Already clean, divisible by k
        String s5 = "abcdEF";
        int k5 = 3;
        System.out.println("Test 5:");
        System.out.println("  s      = " + s5);
        System.out.println("  k      = " + k5);
        System.out.println("  result = " + sol.licenseKeyFormatting(s5, k5));
        System.out.println("  expect = ABC-DEF");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // use String.replace()
        String str = s.replace("-", "").toUpperCase();
        int len = str.length();
        int first = len % k;
        StringBuilder sb = new StringBuilder();
        
        int i = 0;

        if (first > 0) {
            // StringBuilder.append() can do range select, same rule as substring()
            sb.append(str, 0, first);
            i = first;
            if (i < len) sb.append("-");
        }

        while (i < len) {
            sb.append(str, i, i + k);
            i += k;
            if (i < len) sb.append("-");
        }

        return sb.toString();
    }
}
