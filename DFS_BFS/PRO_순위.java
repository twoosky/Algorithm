package DFS_BFS;

import java.util.*;

class PRO_순위 {
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static int[] result;

    public int solution(int n, int[][] results) {
        int answer = 0;
        result = new int[n + 1];
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] num : results) {
            graph.get(num[0]).add(num[1]);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int count = 0;
            while(!q.isEmpty()) {
                int node = q.poll();
                for(int v : graph.get(node)) {
                    if (!visited[v]) {
                        result[v] += 1;
                        count++;
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
            result[i] += count;
        }

        for(int num : result) {
            if (num == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
