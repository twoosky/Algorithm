package Re.re2;

import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    int weight;
    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class ch09_다익스트라 {
    private static List<List<Edge>> graph;
    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        graph = new ArrayList<>();
        dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < m; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            int weight = in.nextInt();
            graph.get(node1).add(new Edge(node2, weight));
        }

        dijkstra(1);

        for(int i = 2; i < n + 1; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + dp[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        Queue<Edge> q = new PriorityQueue<>();
        dp[start] = 0;
        q.offer(new Edge(start, 0));

        while(!q.isEmpty()) {
            Edge now = q.poll();
            if (dp[now.node] < now.weight) {
                continue;
            }
            for(Edge edge : graph.get(now.node)) {
                int newWeight = dp[now.node] + edge.weight;
                if (dp[edge.node] > newWeight) {
                    dp[edge.node] = newWeight;
                    q.offer(new Edge(edge.node, newWeight));
                }
            }
        }
    }
}

/*
입력 예제
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 */

/*
출력 예제
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
 */
