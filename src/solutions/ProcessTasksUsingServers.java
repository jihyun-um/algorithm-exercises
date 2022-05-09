package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/process-tasks-using-servers
class ProcessTasksUsingServers {
    // Two heaps
    // O((m + n)*logn) time, O(n) space
    // where m = number of tasks, n = number of servers
    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<Server> availableServers = new PriorityQueue<>((a, b) -> a.weight != b.weight ? a.weight - b.weight : a.index - b.index);
        for (int i = 0; i < servers.length; i++) {
            availableServers.add(new Server(i, servers[i]));
        }
        int[] serversUsed = new int[tasks.length];
        Queue<Server> inUseServers = new PriorityQueue<>((a, b) ->
                a.nextAvailableTime != b.nextAvailableTime
                        ? a.nextAvailableTime - b.nextAvailableTime
                        : (a.weight != b.weight ? a.weight - b.weight : a.index - b.index)
        );
        for (int j = 0; j < tasks.length; j++) {
            if (!inUseServers.isEmpty() && inUseServers.peek().nextAvailableTime <= j) {
                availableServers.add(inUseServers.poll());
            }
            Server server;
            if (!availableServers.isEmpty()) {
                server = availableServers.poll();
                server.nextAvailableTime = j + tasks[j];
            } else {
                // If there is no free servers now, find the used server with the smallest available time
                server = inUseServers.poll();
                server.nextAvailableTime += tasks[j];
            }
            serversUsed[j] = server.index;
            inUseServers.add(server);
        }
        return serversUsed;
    }

    // Test
    public static void main(String[] args) {
        ProcessTasksUsingServers solution = new ProcessTasksUsingServers();

        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        int[] expectedOutput = {2, 2, 0, 2, 1, 2};
        int[] actualOutput = solution.assignTasks(servers, tasks);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }
}

class Server {
    int index;
    int weight;
    int nextAvailableTime;

    public Server(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}