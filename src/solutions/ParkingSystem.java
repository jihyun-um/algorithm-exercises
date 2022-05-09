package solutions;

// [Problem] https://leetcode.com/problems/design-parking-system
class ParkingSystem {
    int[] availableSpots;

    public ParkingSystem(int big, int medium, int small) {
        availableSpots = new int[]{big, medium, small};
    }

    // O(1) time, O(1) space
    public boolean addCar(int carType) {
        // carType: 1 = big, 2 = medium, 3 = small
        return availableSpots[carType - 1]-- > 0;
    }

    // test
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        boolean output1 = parkingSystem.addCar(1); // true
        boolean output2 = parkingSystem.addCar(2); // true
        boolean output3 = parkingSystem.addCar(3); // false
        boolean output4 = parkingSystem.addCar(1); // false

        System.out.println("Test 1 passed? " + (output1 == true));
        System.out.println("Test 2 passed? " + (output2 == true));
        System.out.println("Test 3 passed? " + (output3 == false));
        System.out.println("Test 4 passed? " + (output4 == false));
    }
}
