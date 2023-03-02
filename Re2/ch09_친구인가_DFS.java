package Re2;

import java.util.*;

public class ch09_친구인가_DFS {
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        visited = new boolean[n + 1];
        int a = in.nextInt();
        int b = in.nextInt();

        dfs(a);
        if(visited[b]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        for(int num : graph.get(idx)) {
            if (!visited[num]) {
                dfs(num);
            }
        }
    }
}
