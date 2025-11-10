package ArrayAndStringType.Text_Justification;
import java.util.*;

public class textJustification {
    public static void main(String[] args){
        String[][] testArr = new String[4][];
        testArr[0] = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        testArr[1] = new String[]{"What","must","be","acknowledgment","shall","be"};
        testArr[2] = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        testArr[3] = new String[]{"Listen","to","many,","speak","to","a","few."};

        int[] maxWidthArr = new int[]{16,16,20,6};

        Solution sol = new Solution();

        for (int i = 0; i < testArr.length; i++){
            // in both python and java List like collection can be print directly, but not array!
            List<String> resList = sol.fullJustify(testArr[i], maxWidthArr[i]);
            System.out.println(resList);
        }
    }
    
}

class Solution {
    // runs in O(N * maxWidth)

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length; // array use .lenth
        int currIdx = 0;
        List<String> retList = new ArrayList<>(); // List/ArrayList use .size()

        while (currIdx < len){
            List<String> currList = new ArrayList<>(Arrays.asList(words[currIdx])); // initialize with vals
            String currStr = words[currIdx];
            int currLen = currStr.length(); // String use .length()
            int nextIdx = currIdx + 1;

            // use greedy throughts to maximize the words taken & determine nextIdx
            while (nextIdx < len && currLen + 1 + words[nextIdx].length() <= maxWidth){
                currList.add(" ");
                currList.add(words[nextIdx]);
                currLen += words[nextIdx].length() + 1;
                nextIdx++;
            }

            // determine is it last line
            boolean isLastLine = nextIdx == len;
            if (isLastLine){ // last line --- left justification
                String s = String.join("", currList);
                int remainSpaces = maxWidth - currLen;
                for (int i = remainSpaces; i > 0; i--){
                    s += " ";
                }
                retList.add(s);
                currIdx = nextIdx;
                continue;
            }

            // determine is it single word forming a line
            if (currList.size() == 1 && currLen + 1 <= maxWidth){
                currList.add(" "); // append one space so the remainSpaces have place to go
                currLen += 1;
            }

            // cal remainSpaces & evenly distribute them between words
            int remainSpaces = maxWidth - currLen;
            while (remainSpaces > 0){
                for (int i = 0; i < currList.size(); i++){
                    if (currList.get(i).charAt(0) == ' '){
                        currList.set(i, currList.get(i) + " ");
                        remainSpaces--;
                        if (remainSpaces <= 0) break;
                    }
                }
            }

            // done, append to retList & update currIdx & go for next line
            String s = String.join("", currList);
            retList.add(s);
            currIdx = nextIdx;     
        }
        return retList;
    }
}