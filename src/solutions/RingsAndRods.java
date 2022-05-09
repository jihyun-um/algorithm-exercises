package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// [Problem] https://leetcode.com/problems/rings-and-rods
class RingsAndRods {
    // Color Array
    // O(n) time, O(1) space
    public int countPoints(String input) {
        int[] red = new int[10], green = new int[10], blue = new int[10];
        for (int i = 0; i < input.length(); i += 2) {
            char color = input.charAt(i);
            int rodNumber = input.charAt(i + 1) - '0';
            if (color == 'R') {
                red[rodNumber]++;
            } else if (color == 'G') {
                green[rodNumber]++;
            } else if (color == 'B') {
                blue[rodNumber]++;
            }
        }
        int count = 0;
        for (int j = 0; j < 10; j++) {
            if (red[j] > 0 && green[j] > 0 && blue[j] > 0) {
                count++;
            }
        }
        return count;
    }

    // Rod HashTable
    // O(n) time, O(1) space
    public int countPointsHashTable(String input) {
        Map<Integer, Map<Character, Boolean>> rods = new HashMap<>();
        Set<Integer> countedRods = new HashSet<>();
        for (int i = 0; i < input.length() - 1; i += 2) {
            int rodNumber = input.charAt(i + 1) - '0';
            if (countedRods.contains(rodNumber)) {
                continue;
            }
            char color = input.charAt(i);
            Map<Character, Boolean> rings = rods.getOrDefault(rodNumber, new HashMap<>());
            rings.put(color, true);
            if (rings.getOrDefault('R', false)
                    && rings.getOrDefault('G', false)
                    && rings.getOrDefault('B', false)) {
                countedRods.add(rodNumber);
            }
            rods.put(rodNumber, rings);
        }
        return countedRods.size();
    }

    // Test
    public static void main(String[] args) {
        RingsAndRods solution = new RingsAndRods();

        String input = "B0B6G0R6R0R6G9";
        int expectedOutput = 1;
        int actualOutput = solution.countPoints(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
