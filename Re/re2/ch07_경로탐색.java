package Re.re2;

import java.util.*;

public class ch07_경로탐색 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        visited = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            graph.get(s).add(e);
        }

        visited[1] = true;
        dfs(1, n);
    }

    private static void dfs(int node, int n) {
        if (node == n) {
            print();
            return;
        }

        for(int num : graph.get(node)) {
            if (!visited[num]) {
                visited[num] = true;
                dfs(num, n);
                visited[num] = false;
            }
        }
    }

    private static void print() {
        for(int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
