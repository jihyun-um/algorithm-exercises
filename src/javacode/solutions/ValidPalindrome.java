package javacode.solutions;

// [Problem] https://leetcode.com/problems/valid-palindrome
class ValidPalindrome {
    // Two pointers
    // O(n) time, O(1) space
    public boolean isPalindrome(String input) {
        for (int left = 0, right = input.length() - 1; left < right; left++, right--) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
                return false;
            }
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        String input1 = "A man, a plan, a canal: Panama";
        boolean output1 = solution.isPalindrome(input1);
        System.out.println("Test 1 passed? " + (output1 == true));

        String input2 = "race a car";
        boolean output2 = solution.isPalindrome(input2);
        System.out.println("Test 2 passed? " + (output2 == false));
    }
}
