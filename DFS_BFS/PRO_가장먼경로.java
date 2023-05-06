package DFS_BFS;

import java.util.*;

class PRO_가장먼경로 {
    private static List<List<Integer>> graph;
    private static int[] result;

    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        boolean[] visited = new boolean[n+1];
        result = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int num : graph.get(node)) {
                if (!visited[num]) {
                    visited[num] = true;
                    result[num] = result[node] + 1;
                    q.offer(num);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }

        int answer = 0;
        for(int num : result) {
            System.out.print(num + " ");
            if (num == max) {
                answer++;
            }
        }

        return answer;
    }
}
