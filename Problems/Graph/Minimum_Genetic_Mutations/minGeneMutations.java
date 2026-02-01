package Graph.Minimum_Genetic_Mutations;

import java.util.*;

public class minGeneMutations {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // startGene = "AACCGGTT"
        // endGene   = "AACCGGTA"
        // bank      = ["AACCGGTA"]
        // Expected: 1
        String start1 = "AACCGGTT";
        String end1 = "AACCGGTA";
        String[] bank1 = {"AACCGGTA"};

        int ans1 = sol.minMutation(start1, end1, bank1);
        System.out.println("Test 1:");
        System.out.println("  start = " + start1);
        System.out.println("  end   = " + end1);
        System.out.println("  bank  = " + Arrays.toString(bank1));
        System.out.println("  result= " + ans1);
        System.out.println("  expect= 1");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // startGene = "AACCGGTT"
        // endGene   = "AAACGGTA"
        // bank      = ["AACCGGTA","AACCGCTA","AAACGGTA"]
        // One shortest path:
        // AACCGGTT -> AACCGGTA -> AAACGGTA  (2 steps)
        // Expected: 2
        String start2 = "AACCGGTT";
        String end2 = "AAACGGTA";
        String[] bank2 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        int ans2 = sol.minMutation(start2, end2, bank2);
        System.out.println("Test 2:");
        System.out.println("  start = " + start2);
        System.out.println("  end   = " + end2);
        System.out.println("  bank  = " + Arrays.toString(bank2));
        System.out.println("  result= " + ans2);
        System.out.println("  expect= 2");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // Impossible case (endGene not in bank) -> must return -1
        String start3 = "AAAAACCC";
        String end3 = "AACCCCCC";
        // Let's make it truly impossible by removing it:
        String[] bank3_impossible = {"AAAACCCC", "AAACCCCC"};

        int ans3 = sol.minMutation(start3, end3, bank3_impossible);
        System.out.println("Test 3:");
        System.out.println("  start = " + start3);
        System.out.println("  end   = " + end3);
        System.out.println("  bank  = " + Arrays.toString(bank3_impossible));
        System.out.println("  result= " + ans3);
        System.out.println("  expect= -1");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // start == end (some platforms expect 0 even if end not in bank; your current code returns -1
        // because you check !bankSet.contains(endGene) first.
        // We'll show this case so you can decide if you want to handle it.
        String start4 = "AACCGGTT";
        String end4 = "AACCGGTT";
        String[] bank4 = {}; // empty bank

        int ans4 = sol.minMutation(start4, end4, bank4);
        System.out.println("Test 4:");
        System.out.println("  start = " + start4);
        System.out.println("  end   = " + end4);
        System.out.println("  bank  = " + Arrays.toString(bank4));
        System.out.println("  result= " + ans4);
        System.out.println("  expect= (depends on spec; often 0)");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 5 ----------------------
        // Larger bank with multiple paths; ensures BFS finds shortest
        String start5 = "AAAAAAAT";
        String end5 = "AAAAAATT";
        String[] bank5 = {
            "AAAAAAAT", // may or may not be in bank, doesn't matter
            "AAAAAATT",
            "AAAAAACT",
            "AAAAAACT",
            "AAAAAAGT"
        };
        // shortest: AAAAAAAT -> AAAAAATT (1 step if AAAAAATT in bank) and differs 1 char? Actually:
        // "AAAAAAAT" vs "AAAAAATT": differs at index 6? let's compare:
        // AAAAAAAT
        // AAAAAATT
        // positions: 0..7
        // A A A A A A A T
        // A A A A A A T T
        // differs at position 6 only (A->T), so 1 step.
        int ans5 = sol.minMutation(start5, end5, bank5);
        System.out.println("Test 5:");
        System.out.println("  start = " + start5);
        System.out.println("  end   = " + end5);
        System.out.println("  bank  = " + Arrays.toString(bank5));
        System.out.println("  result= " + ans5);
        System.out.println("  expect= 1");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    /**
    This question the mutation implies using BFS to explore every possibility of original str change
    one digit into a middle str(put in the dq), and use the middle str to do until reach the endStr
    or dq is empty
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        // we will need a set to do O(1) look up for the middle str
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank)); // arr => List => constructor Set
        if (!bankSet.contains(endGene)) return -1;

        Deque<String> dq = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        dq.offer(startGene);
        // use visited set to prevent we go back to prev step and eventually run out of memo
        visited.add(startGene);
        char[] choices = new char[]{ 'A', 'C', 'G', 'T' };
        int steps = 0;

        while (!dq.isEmpty()) {
            int size = dq.size(); // use size to control the layers
            for (int s = 0; s < size; s++) {
                // current layer: for 8 * 3 = 24 mutations, its not just one digit mutation, its all
                // next layer will be mid str do 24 mutations again, until reach the endGene
                String curr = dq.poll();
                if (curr.equals(endGene)) return steps;

                char[] chrArr = curr.toCharArray();
                for (int i = 0; i < curr.length(); i++) {
                    char currChr = chrArr[i];

                    for (char choice : choices) {
                        if (currChr == choice) continue;

                        chrArr[i] = choice;
                        String midStr = new String(chrArr);
                        if (bankSet.contains(midStr) && !visited.contains(midStr)) {
                            visited.add(midStr);
                            dq.offer(midStr);
                        }
                    }

                    chrArr[i] = currChr; // convert back
                }
            }
            steps++;
        }
        return -1;
    }
}
