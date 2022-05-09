package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/valid-anagram/
class ValidAnagram {

    // test
    public static void main(String[] args) {

        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Test passed? " + (isAnagram(s1, t1) == true));

        String s2 = "car";
        String t2 = "rat";
        System.out.println("Test passed? " + (isAnagram(s2, t2) == false));
    }

    // O(NlogN) Sort solution
    private static boolean isAnagramWithSort(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    // O(N) HashTable solution
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
