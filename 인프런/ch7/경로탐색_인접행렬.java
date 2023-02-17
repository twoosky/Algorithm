package 인프런.ch7;

import java.util.*;

public class 경로탐색_인접행렬 {
    private static int count = 0;
    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 노드 종류 개수
        int m = in.nextInt(); // 간선 개수
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph[x][y] = 1;
        }

        dfs1(n, 1);
        System.out.println("count : " + count);
    }

    private static void dfs1(int dest, int node) {
        visited[node] = true;
        if (node == dest) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) stringBuilder.append(i + " ");
            }
            System.out.println(stringBuilder);
            count++;
            visited[dest] = false;
        }
        for(int i = 1; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs1(dest, i);
                visited[i] = false;
            }
        }
    }

    /* 기본 재귀 DFS */
    private static void dfs2(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        for(int i = 1; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs2(i, graph, visited);
            }
        }
    }
}


/* 입력 예제
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 */

/* 출력 예제
1 2 3 4 5
1 2 5
1 2 3 4 5
1 3 4 5
1 2 4 5
1 4 5
count : 6
 */