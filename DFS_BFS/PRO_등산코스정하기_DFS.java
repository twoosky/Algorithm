package DFS_BFS;

import java.util.*;

class Vertex {
    int v;
    int cost;
    public Vertex(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

class PRO_등산코스정하기_DFS {
    private static List<List<Vertex>> graph;
    private static boolean[] visited;
    private static int[] result = {0, Integer.MAX_VALUE};

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < paths.length; i++) {
            int[] path = paths[i];
            graph.get(path[0]).add(new Vertex(path[1], path[2]));
            graph.get(path[1]).add(new Vertex(path[0], path[2]));
        }

        Arrays.sort(summits);
        visited = new boolean[n + 1];
        for(int gate : gates) {
            for(int summit : summits) {
                Arrays.fill(visited, false);
                for(int s : summits) {
                    if (s != summit) {
                        visited[s] = true;
                    }
                }
                dfs(gate, summit, Integer.MIN_VALUE);
            }
        }
        return result;
    }

    private void dfs(int start, int dest, int intensity) {
        if (intensity >= result[1]) {
            return;
        }

        if (start == dest) {
            result[0] = dest;
            result[1] = intensity;
            System.out.println(result[0] + " " + result[1]);
            return;
        }

        for(Vertex vertex : graph.get(start)) {
            if (!visited[vertex.v]) {
                visited[vertex.v] = true;
                dfs(vertex.v, dest, Math.max(intensity, vertex.cost));
                visited[vertex.v] = false;
            }
        }
    }
}
