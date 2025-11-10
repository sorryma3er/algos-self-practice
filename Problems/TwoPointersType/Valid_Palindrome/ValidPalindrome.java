package TwoPointersType.Valid_Palindrome;

public class ValidPalindrome {
    public static void main(String[] args) {
        String[] test = new String[]{"A man, a plan, a canal: Panama", "race a car", " ", "0P"};
        Solution sol = new Solution();
        boolean[] expect = new boolean[]{true, false, true, false};

        System.out.println("=== Valid Palindrome Test Results ===");

        int passed = 0;

        for (int i = 0; i < test.length; i++) {
            boolean got = sol.isPalindrome(test[i]);
            boolean ok = (got == expect[i]);

            System.out.printf(
                "[Case %d]%nInput: \"%s\"%nExpected: %s%nGot: %s%nResult: %s%n%n",
                i + 1, test[i], expect[i], got, ok ? "PASS ✅" : "FAIL ❌"
            );

            if (ok) passed++;
        }

        System.out.printf("Summary: %d/%d test cases passed.%n", passed, test.length);

    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        // two-pointer thought
        int frontIdx = 0;
        int endIdx = s.length() - 1;

        while (frontIdx < endIdx){
            char front = Character.toUpperCase(s.charAt(frontIdx));
            char end = Character.toUpperCase(s.charAt(endIdx));

            // check are both idx are letter
            if (!Character.isLetterOrDigit(front)){
                frontIdx++;
                continue;
            } else if (!Character.isLetterOrDigit(end)) {
                endIdx--;
                continue;
            }

            if (front != end) return false;
            frontIdx++;
            endIdx--;
        }

        return true;
    }
}
