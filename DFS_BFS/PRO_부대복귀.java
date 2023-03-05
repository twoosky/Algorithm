package DFS_BFS;

import java.util.*;

class PRO_부대복귀 {
    private static List<List<Integer>> graph;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        for(int i = 0; i < sources.length; i++) {
            if (sources[i] == destination) {
                answer[i] = 0;
            } else if (graph.get(sources[i]).size() == 0) {
                answer[i] = -1;
            } else {
                answer[i] = bfs(sources[i], destination);
            }
        }

        return answer;
    }

    private int bfs(int start, int dest) {
        int distance = 0;
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int now = q.poll();
                for(int node : graph.get(now)) {
                    if (node == dest) {
                        return distance + 1;
                    }
                    if (!visited[node]) {
                        visited[node] = true;
                        q.offer(node);
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}
