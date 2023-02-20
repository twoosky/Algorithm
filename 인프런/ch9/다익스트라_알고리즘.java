package 인프런.ch9;

import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;
    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    // 우선순위 큐는 compareTo을 기준으로 정렬된다.
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class 다익스트라_알고리즘 {
    private static List<List<Edge>> graph;
    private static int[] dis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList<>();
        dis = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            dis[i] = Integer.MAX_VALUE;
        }

        Arrays.fill(dis, Integer.MAX_VALUE);

        dynamic(1);
        for(int i = 2; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
                continue;
            }
            System.out.println(i + " : " + dis[i]);
        }
    }

    private static void dynamic(int v) {
        Queue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;

        while(!pQ.isEmpty()) {
            Edge now = pQ.poll();
            if (dis[now.vertex] < now.cost) {
                continue;
            }
            for(Edge edge : graph.get(now.vertex)) {
                int newCost = now.cost + edge.cost;
                if (dis[edge.vertex] > newCost) {
                    dis[edge.vertex] = newCost;
                    pQ.offer(new Edge(edge.vertex, newCost));
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

/*
0. 우선순위 큐가 cost 값이 큰 순서대로 정렬되도록 compareTo 메서드 오버라이딩
1. dis 배열을 Integer.MAX_VALUE 로 초기화
2. 처음 시작 노드를 우선순위 큐에 삽입
3. 우선순위 큐에서 노드 하나 꺼내고, 해당 노드(now)와 연결된 노드(edge) 탐색
4. dis[edge.vertex] > now.cost + edge.cost 이면
   dis 배열 업데이트 후 우선순위 큐에 연결된 노드(edge)와 새로운 cost 삽입
   - dis는 시작 노드에서 해당 노드까지의 거리가 저장되어 있다.
   - 연결된 노드들을 탐색하며 연결된 노드까지 가는 최소비용을 계속 업데이트하는 구조
5. 만약 dis 배열에 해당 노드값이 이미 최소값으로 저장되어 있으면,
   우선순위 큐에서 해당 노드를 꺼내도 dis 배열을 업데이트할 필요 없음
 */