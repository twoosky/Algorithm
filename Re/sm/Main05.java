package Re.sm;

import java.util.*;

class Vertex {
    int v;
    int cost;
    public Vertex(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main05 {
    private static List<List<Vertex>> graph;
    private static int[] amount;
    private static List<int[]> result;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            graph.get(in.nextInt()).add(new Vertex(in.nextInt(), in.nextInt()));
        }

        amount = new int[n + 1];
        for(int i = 0; i < m; i++) {
            amount[in.nextInt()] = in.nextInt();
        }

        result = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[1] = true;
            dfs(1, i, 0);
        }

        Collections.sort(result, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o2[1] - o2[0];
        });

        System.out.print(result.get(0)[0] + " " + result.get(0)[1]);
    }

    private static void dfs(int v, int dest, int cost) {
        if (v == dest) {
            int c = amount[dest] - (cost * 2);
            int[] arr = {dest, c};
            result.add(arr);
            return;
        }

        for(Vertex vertex : graph.get(v)) {
            if (!visited[vertex.v]) {
                visited[vertex.v] = true;
                dfs(vertex.v, dest, cost + vertex.cost);
                visited[vertex.v] = false;
            }
        }
    }
}

/*
4 3
1 2 3
1 3 1
3 4 3
4 10
2 7
3 4
 */
