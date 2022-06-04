package solutions;

// [Problem] https://leetcode.com/problems/product-of-the-last-k-numbers

import java.util.ArrayList;
import java.util.List;

// Prefix product
class ProductOfNumbers {
    List<Integer> prefix; // O(n) space

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    // O(1) time
    public void add(int num) {
        if (num != 0) {
            int lastPrefix = prefix.get(prefix.size() - 1);
            prefix.add(lastPrefix * num);
        } else {
            prefix = new ArrayList<>();
            prefix.add(1);
        }
    }

    // O(1) time
    public int getProduct(int k) {
        int n = prefix.size();
        if (k >= n) {
            return 0;
        }
        return prefix.get(n - 1) / prefix.get(n - k - 1);
    }

    // Test
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
}