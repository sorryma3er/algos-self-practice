package ArrayAndStringType.Roman_To_Int;

public class RomanToInt {
    public static void main(String[] args) {
        String letter = "MMDLXXXIX";
        System.out.println(new Solution().romanToInt(letter));
    }
}

class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int len = s.length();

        for (int i = 0; i < len; i++){
            char curr = s.charAt(i);
            switch (curr) {
                case 'M':
                    total += 1000;
                    break;

                case 'D':
                    total += 500;
                    break;
                
                case 'C':
                    if (i + 1 != len && s.charAt(i + 1) == 'M') {
                        total += 900;
                        i++;
                    }
                    else if(i + 1 != len && s.charAt(i + 1) == 'D') {
                        total += 400;
                        i++;
                    }
                    else total += 100;

                    break;

                case 'L':
                    total += 50;
                    break;

                case 'X':
                    if (i + 1 != len && s.charAt(i + 1) == 'C'){
                        total += 90;
                        i++;
                    }
                    else if (i + 1 != len && s.charAt(i + 1) == 'L'){
                        total += 40;
                        i++;
                    }
                    else total += 10;

                    break;

                case 'V':
                    total += 5;
                    break;

                case 'I':
                    if (i + 1 != len && s.charAt(i + 1) == 'V'){
                        total += 4;
                        i++;
                    }
                    else if (i + 1 != len && s.charAt(i + 1) == 'X'){
                        total += 9;
                        i++;
                    }
                    else total++;
                    break;
            }
        }
        return total;
    }
}
