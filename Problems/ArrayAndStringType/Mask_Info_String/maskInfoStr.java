package ArrayAndStringType.Mask_Info_String;

public class maskInfoStr {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Email cases ----------------------
        System.out.println("Email Test 1:");
        String s1 = "LeetCode@LeetCode.com";
        System.out.println("  input   = " + s1);
        System.out.println("  output  = " + sol.maskPII(s1));
        System.out.println("  expect  = l*****e@leetcode.com");
        System.out.println("-----------------------------------");

        System.out.println("Email Test 2:");
        String s2 = "AB@qq.com";
        System.out.println("  input   = " + s2);
        System.out.println("  output  = " + sol.maskPII(s2));
        System.out.println("  expect  = a*****b@qq.com");
        System.out.println("-----------------------------------");

        // ---------------------- Phone cases ----------------------
        System.out.println("Phone Test 1 (no country code):");
        String p1 = "1(234)567-890";
        System.out.println("  input   = " + p1);
        System.out.println("  output  = " + sol.maskPII(p1));
        System.out.println("  expect  = ***-***-7890");
        System.out.println("-----------------------------------");

        System.out.println("Phone Test 2 (country code 1):");
        String p2 = "+1 (234) 567-890";
        System.out.println("  input   = " + p2);
        System.out.println("  output  = " + sol.maskPII(p2));
        System.out.println("  expect  = +*-***-***-7890");
        System.out.println("-----------------------------------");

        System.out.println("Phone Test 3 (country code 2):");
        String p3 = "+86 138 0013 8000";
        System.out.println("  input   = " + p3);
        System.out.println("  output  = " + sol.maskPII(p3));
        System.out.println("  expect  = +**-***-***-8000");
        System.out.println("-----------------------------------");

        System.out.println("Phone Test 4 (country code 3):");
        String p4 = "+(123) 456-789-0123";
        System.out.println("  input   = " + p4);
        System.out.println("  output  = " + sol.maskPII(p4));
        System.out.println("  expect  = +***-***-***-0123");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public String maskPII(String s) {
        String[] arr = s.split("@");
        StringBuilder sb = new StringBuilder();

        if (arr.length > 1) {
            String name = arr[0].toLowerCase(), domain = arr[1].toLowerCase();

            sb.append(name.charAt(0))
                .append("*****")
                .append(name.charAt(name.length() - 1))
                .append("@")
                .append(domain);
        }
        else {
            String cleaned = 
                s.replace("+", "")
                    .replace("-", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace(" ", "");

            int len = cleaned.length();
            if (len - 10 == 1) sb.append("+*-");
            else if (len - 10 == 2) sb.append("+**-");
            else if (len - 10 == 3) sb.append("+***-");
            
            sb.append("***-***-")
                .append(cleaned, len - 4, len);
        }
        return sb.toString();
    }
}
