package 이론.code;

import java.util.*;

public class DFS {
    private static boolean visited[];
    private static List<List<Integer>> graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        graph = new ArrayList<>();
        graph.add(List.of());
        graph.add(List.of(2, 3, 8));  // 1번 노드
        graph.add(List.of(1, 7));     // 2번 노드
        graph.add(List.of(1, 4, 5));  // 3번 노드
        graph.add(List.of(3, 5));     // 4번 노드
        graph.add(List.of(3, 4));     // 5번 노드
        graph.add(List.of(7));        // 6번 노드
        graph.add(List.of(2, 6, 8));  // 7번 노드
        graph.add(List.of(1, 7));     // 8번 노드

        visited = new boolean[9];
        dfs(1);
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int n : graph.get(node)) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}
