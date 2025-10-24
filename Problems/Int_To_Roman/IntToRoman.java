public class IntToRoman {
    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        while (num > 0) {
            if (num / 1000 > 0) {
                int fac = num / 1000;
                for (int i = 0; i < fac; i++) roman.append('M');
                num %= 1000;
            } else if (num / 100 > 0) {
                int fac = num / 100;
                if (fac >= 9) {
                    roman.append("CM");
                    num -= 900;
                } else if (fac >= 5) {
                    roman.append('D');
                    num -= 500;
                } else if (fac >= 4) {
                    roman.append("CD");
                    num -= 400;
                } else {
                    for (int i = 0; i < fac; i++) roman.append('C');
                    num -= 100 * fac;
                }
            } else if (num / 10 > 0) {
                int fac = num / 10;
                if (fac >= 9) {
                    roman.append("XC");
                    num -= 90;
                } else if (fac >= 5) {
                    roman.append('L');
                    num -= 50;
                } else if (fac >= 4) {
                    roman.append("XL");
                    num -= 40;
                } else {
                    for (int i = 0; i < fac; i++) roman.append('X');
                    num -= fac * 10;
                }
            } else { // num / 1 > 0
                if (num >= 9) {
                    roman.append("IX");
                    num -= 9;
                } else if (num >= 5) {
                    roman.append('V');
                    num -= 5;
                } else if (num >= 4) {
                    roman.append("IV");
                    num -= 4;
                } else {
                    for (int i = 0; i < num; i++) roman.append('I');
                    num = 0;
                }
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1287)); // MCCLXXXVII

    }
}
