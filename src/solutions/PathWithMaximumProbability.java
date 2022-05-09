package solutions;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

// [Problem] https://leetcode.com/problems/path-with-maximum-probability
class PathWithMaximumProbability {
    // BFS
    // O(v + e) time, O(v + e) space
    public double maxProbability(int n, int[][] edges, double[] probabilities, int start, int end) {
        HashSet<Edge>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int j = 0; j < edges.length; j++) {
            int[] edge = edges[j];
            double probability = probabilities[j];
            graph[edge[0]].add(new Edge(edge[1], probability));
            graph[edge[1]].add(new Edge(edge[0], probability));
        }
        Queue<Edge> edgesToVisit = new ArrayDeque<>();
        double[] maxProbabilities = new double[n];
        edgesToVisit.add(new Edge(start, 1D));
        while (!edgesToVisit.isEmpty()) {
            Edge edge = edgesToVisit.poll();
            int sourceNode = edge.node;
            double probability = edge.probability;
            Set<Edge> nextEdges = graph[sourceNode];
            for (Edge nextEdge : nextEdges) {
                int nextNode = nextEdge.node;
                double newProbability = probability * nextEdge.probability;
                if (maxProbabilities[nextNode] < newProbability) {
                    edgesToVisit.add(new Edge(nextNode, newProbability));
                    maxProbabilities[nextNode] = newProbability;
                }
            }
        }
        return maxProbabilities[end];
    }

    // Test
    public static void main(String[] args) {
        PathWithMaximumProbability solution = new PathWithMaximumProbability();

        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] probabilities = {0.5, 0.5, 0.2};
        int n = 3, start = 0, end = 2;
        double expectedOutput = 0.25;
        double actualOutput = solution.maxProbability(n, edges, probabilities, start, end);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}

class Edge {
    int node;
    double probability;

    public Edge(int node, double probability) {
        this.node = node;
        this.probability = probability;
    }
}
