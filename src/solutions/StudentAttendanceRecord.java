package solutions;

// [Problem] https://leetcode.com/problems/student-attendance-record-i
class StudentAttendanceRecord {
    // String scan
    // O(n) time, O(1) space
    public boolean checkRecord(String s) {
        int absentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
                if (absentCount >= 2) {
                    return false;
                }
            } else if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        StudentAttendanceRecord solution = new StudentAttendanceRecord();

        String input1 = "PPALLP";
        boolean output1 = solution.checkRecord(input1);
        System.out.println("Test 1 passed? " + (output1 == true));

        String input2 = "PPALLL";
        boolean output2 = solution.checkRecord(input2);
        System.out.println("Test 1 passed? " + (output2 == false));
    }
}
