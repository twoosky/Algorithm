package 우선순위큐;

import java.util.*;

class Edge {
    int val;
    int cost;
    public Edge(int val, int cost) {
        this.val = val;
        this.cost = cost;
    }
}

public class 다익스트라 {
    private static List<List<Edge>> graph;
    private static int dp[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        graph = new ArrayList<>();
        dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            int weight = in.nextInt();
            graph.get(node1).add(new Edge(node2, weight));
        }
        dijkstra(1);
        for(int i = 1; i < dp.length; i ++) {
            System.out.println(i + ": " + dp[i]);
        }
    }

    private static void dijkstra(int start) {
        Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Edge(start, 0));
        dp[start] = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (dp[edge.val] < edge.cost) {
                continue;
            }
            for(Edge e : graph.get(edge.val)) {
                int newCost = dp[edge.val] + e.cost;
                if (newCost < dp[e.val]) {
                    dp[e.val] = newCost;
                    pq.offer(new Edge(e.val, newCost));
                }
            }
        }
    }
}
