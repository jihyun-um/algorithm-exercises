package javacode.solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/destination-city
class DestinationCity {
    // HashMap
    // O(n) time, O(n) space
    public String destCity(List<List<String>> paths) {
        Map<String, String> cityConnections = new HashMap<>();
        for (List<String> path : paths) {
            cityConnections.put(path.get(0), path.get(1));
        }
        for (String city : cityConnections.values()) {
            if (!cityConnections.containsKey(city)) {
                return city;
            }
        }
        return null;
    }

    // HashSet
    // O(n) time, O(n) space
    public String destCityWithSet(List<List<String>> paths) {
        Set<String> departureCities = new HashSet<>();
        for (List<String> path : paths) {
            departureCities.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!departureCities.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }

    // Test
    public static void main(String[] args) {
        DestinationCity solution = new DestinationCity();

        List<List<String>> input = List.of(List.of("B", "C"), List.of("D", "B"), List.of("C", "A"));
        String expectedOutput = "A";
        String actualOutput = solution.destCity(input);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
