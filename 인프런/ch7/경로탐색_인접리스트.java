package 인프런.ch7;

import java.util.*;

public class 경로탐색_인접리스트 {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int n;
    private static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();  // 노드의 수 (목적지 노드)
        int m = in.nextInt();  // 간선의 수 (연결 정보)
        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            graph.get(node1).add(node2);
        }

        dfs(1);
        System.out.print("count : " + count);
    }

    private static void dfs(int node) {
        visited[node] = true;

        if(node == n) {
            count++;
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 1; i < visited.length; i++) {
                if (visited[i]) stringBuilder.append(i + " ");
            }
            System.out.println(stringBuilder);
            visited[node] = false;
        } else {
            for(int num : graph.get(node)) {
                if(!visited[num]) {
                    dfs(num);
                    visited[num] = false;
                }
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