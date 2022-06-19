package solutions;

// [Problem] https://leetcode.com/problems/snapshot-array

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hash table storing differences in each snapshot
class SnapshotArray {
    List<Map<Integer, Integer>> diff;

    // O(m * n) space
    // where m = number of snapshots, n = number of changes in each snapshot
    public SnapshotArray(int length) {
        diff = new ArrayList<>();
        diff.add(new HashMap<>());
    }

    // O(1) time
    public void set(int index, int val) {
        diff.get(diff.size() - 1).put(index, val);
    }

    // O(1) time
    public int snap() {
        diff.add(new HashMap<>());
        return diff.size() - 2;
    }

    // O(n) time, where n = number of snapshots
    public int get(int index, int snapId) {
        for (int id = snapId; id >= 0; id--) {
            if (diff.get(id).containsKey(index)) {
                return diff.get(id).get(index);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0, 5);  // Set array[0] = 5
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0, 6);
        System.out.println(snapshotArr.get(0, 0));  // Get the value of array[0] with snap_id = 0, return 5
    }
}