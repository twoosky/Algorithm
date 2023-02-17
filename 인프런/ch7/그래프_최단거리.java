package 인프런.ch7;

import java.util.*;

public class 그래프_최단거리 {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 노드의 수
        int m = in.nextInt();  // 간선의 수
        result = new int[n + 1];
        visited = new boolean[n + 1];

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            graph.get(node1).add(node2);
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int depth = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i ++) {
                int node = q.poll();
                for(int num : graph.get(node)) {
                    if (!visited[num]) {
                        q.add(num);
                        visited[num] = true;
                        result[num] = depth;
                    }
                }
            }
            depth++;
        }

        for(int i = 2; i < result.length; i++) {
            System.out.println(i + " : " + result[i]);
        }
    }
}

/* 입력 예제
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 */

/* 출력 예제
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
 */