package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/find-if-path-exists-in-graph
class FindIfPathExistsInGraph {
    // BFS
    // O(v + e) time, O(v + e) space
    public boolean validPathBfs(int n, int[][] edges, int source, int destination) {
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(source);
        visited[source] = true;
        while (!nodesToVisit.isEmpty()) {
            int nextNodes = nodesToVisit.size();
            for (int i = 0; i < nextNodes; i++) {
                int node = nodesToVisit.poll();
                if (node == destination) {
                    return true;
                }
                Set<Integer> connectedNodes = graph[node];
                for (int connectedNode : connectedNodes) {
                    if (!visited[connectedNode]) {
                        nodesToVisit.add(connectedNode);
                        visited[node] = true;
                    }
                }
            }
        }
        return false;
    }

    // DFS
    // O(v + e) time, O(v + e) space
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return dfs(graph, new boolean[n], source, destination);
    }

    private boolean dfs(HashSet<Integer>[] graph, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        Set<Integer> connectedNodes = graph[source];
        for (int connectedNode : connectedNodes) {
            if (!visited[connectedNode] && dfs(graph, visited, connectedNode, destination)) {
                return true;
            }
        }
        return false;
    }

    // Test
    public static void main(String[] args) {
        FindIfPathExistsInGraph solution = new FindIfPathExistsInGraph();

        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        boolean expectedOutput1 = true;
        boolean actualOutput1 = solution.validPath(3, edges1, 0, 2);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        boolean expectedOutput2 = false;
        boolean actualOutput2 = solution.validPath(6, edges2, 0, 5);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}