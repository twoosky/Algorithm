package 인프런.ch9;

import java.util.*;

class Node implements Comparable<Node>{
    int vertex;
    int cost;
    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class 원더랜드_PriorityQueue {
    private static List<List<Node>> graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        graph = new ArrayList<>();

        for(int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int city1 = in.nextInt();
            int city2 = in.nextInt();
            int cost = in.nextInt();
            graph.get(city1).add(new Node(city2, cost));
            graph.get(city2).add(new Node(city1, cost));
        }

        boolean[] visited = new boolean[v + 1];
        System.out.print(solution(1, visited));

    }

    private static int solution(int v, boolean[] visited) {
        int result = 0;
        Queue<Node> pQ = new PriorityQueue<>();
        pQ.add(new Node(v, 0));

        while(!pQ.isEmpty()) {
            Node now = pQ.poll();

            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;
            result += now.cost;
            for(Node node : graph.get(now.vertex)) {
                if (!visited[node.vertex]) {
                    pQ.offer(node);
                }
            }
        }
        return result;
    }
}
