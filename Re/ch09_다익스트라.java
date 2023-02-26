package Re;

import java.util.*;

class Vertex implements Comparable<Vertex> {
    int v;
    int cost;

    public Vertex(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.cost - o.cost;
    }
}

public class ch09_다익스트라 {
    private static List<List<Vertex>> graph;
    private static int[] dis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList<>();
        dis = new int[n+1];
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            dis[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++) {
            graph.get(in.nextInt()).add(new Vertex(in.nextInt(), in.nextInt()));
        }

        Arrays.fill(dis, Integer.MAX_VALUE);

        solution(1);

        for(int num : dis) {
            System.out.println(num);
        }
    }

    private static void solution(int v) {
        Queue<Vertex> pQ = new PriorityQueue<>();
        pQ.add(new Vertex(v, 0));
        dis[v] = 0;

        while(!pQ.isEmpty()) {
            Vertex now = pQ.poll();
            if (dis[now.v] < now.cost) {
                continue;
            }
            for(Vertex vertex : graph.get(now.v)) {
                int newCost = now.cost + vertex.cost;
                if (dis[vertex.v] > newCost) {
                    dis[vertex.v] = newCost;
                    pQ.offer(new Vertex(vertex.v, newCost));
                }
            }
        }
    }
}

/*
1. 최단 경로 담는 배열 최대값으로 초기화
2. 시작 정점 우선순위 큐 삽입
3. 최단경로 배열 시작 정점0으로 초기화
4. 우선순위큐에 값이 있을 동안 반복
5. 우선순위큐에서 정점하나 꺼내기
6. 해당 정점의 비용이 최단경로 배열의 비용보다 크면 continue; dis[2] = 11 인데, (2, 12)가 들어온 경우
7. 해당 정점과 연결된 정점 순회
8. 만약 해당 정점 최단 경로 + 연결된 정점 비용이 최단 경로 배열의 값보다 작으면 이걸로 업데이트
9. 연결된 정점, 새로운 최단 경로 우선순위 큐에 삽입
10. dis 배열 최단경로 배열에 1정점에서 각 정점까지의 최단경로가 담겨있음
 */

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
