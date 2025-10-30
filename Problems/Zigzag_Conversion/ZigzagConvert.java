package Zigzag_Conversion;

import java.util.ArrayList;


public class ZigzagConvert {
    // 1. instead of ArrayList<ArrayList<char>>, since char is primitive
    // 🧮 Primitive types    int, double, char, boolean, etc.    Simple, raw data stored directly in memory.
    // 📦 Reference (Object) types.   Integer, Double, Character, Boolean, String, etc.    Full Java objects with methods, can be used with generics and collections.
    // ArrayList<int> nums = new ArrayList<>(); // ❌ Compilation error
    // ArrayList<Integer> nums = new ArrayList<>(); // ✅ Works
    //
    // Actually Integer, Double, Character, Boolean, Long, Short, Byte, Float ---> wrapper class, a subset of reference type
    // All Java collections — ArrayList, HashMap, HashSet, etc. — are implemented using Java Generics, 
    // class ArrayList<E> { ... }
    // That generic <E> means: “I can store any type that is an Object or subclass of Object.”
    // int (and all primitives) are not objects; They do not inherit from Object; 

    // 2. In java its list.add() python is list.append()

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new Solution().convert(s, 3));
    }
    
}


class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        ArrayList<ArrayList<Character>> target = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            target.add(new ArrayList<Character>());
        }

        int idxRow = 0;
        boolean reverse = false;

        for (int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if (idxRow < numRows - 1 && !reverse){
                target.get(idxRow).add(currChar);
                idxRow++;
            } else if (idxRow == numRows - 1 && !reverse){
                target.get(idxRow).add(currChar);
                idxRow--;
                reverse = !reverse;
            } else if (idxRow > 0 && reverse) {
                target.get(idxRow).add(currChar);
                idxRow--;
            } else if (idxRow == 0 && reverse) {
                target.get(idxRow).add(currChar);
                idxRow++;
                reverse = !reverse;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> lst : target){
            for (char c : lst){
                sb.append(c);
            }
        }
        return sb.toString();

    }
}