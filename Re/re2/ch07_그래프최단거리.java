package Re.re2;

import java.util.*;

public class ch07_그래프최단거리 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        result = new int[n+1];
        visited = new boolean[n+1];

        Arrays.fill(result, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            graph.get(s).add(e);
        }

        bfs();
        for(int i = 2; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int depth = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int node = q.poll();
                for(int edge: graph.get(node)) {
                    if (!visited[edge]) {
                        result[edge] = Math.min(result[edge], depth + 1);
                        q.offer(edge);
                        visited[edge] = true;
                    }
                }
            }
            depth++;
        }
    }
}
