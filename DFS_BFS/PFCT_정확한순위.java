package DFS_BFS;

import java.io.*;
import java.util.*;

public class PFCT_정확한순위 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        for(int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        int count = (int) Arrays.stream(result)
                .filter(size -> size == n - 1)
                .count();

        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            int count = 0;
            visited[current] = true;
            for(int node : graph.get(current)) {
                q.offer(node);
                result[node] += result[current] + 1;
                count++;
            }
            result[current] += count;
        }

        System.out.print(start + " : ");
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
