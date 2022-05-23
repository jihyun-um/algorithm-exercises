package solutions;

// [Problem] https://leetcode.com/problems/one-edit-distance
class OneEditDistance {
    // String
    // O(n) time, O(n) space
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        for (int i = 0; i < Math.min(sLength, tLength); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLength < tLength) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else if (sLength > tLength) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
        }
        return Math.abs(sLength - tLength) == 1;
    }

    // Test
    public static void main(String[] args) {
        OneEditDistance solution = new OneEditDistance();

        boolean output1 = solution.isOneEditDistance("ab", "acb");
        System.out.println("Test 1 passed? " + (output1 == true));

        boolean output2 = solution.isOneEditDistance("", "");
        System.out.println("Test 2 passed? " + (output2 == false));
    }
}
