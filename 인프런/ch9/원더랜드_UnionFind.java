package 인프런.ch9;

import java.util.*;

public class 원더랜드_UnionFind {
    public static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static int[] unf;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        Queue<Edge> pQ = new PriorityQueue<>();

        for(int i = 0; i < e; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int cost = in.nextInt();
            pQ.offer(new Edge(v1, v2, cost));
        }

        unf = new int[v + 1];
        for(int i = 0; i < v + 1; i++) {
            unf[i] = i;
        }

        System.out.print(solution(pQ));
    }

    private static int solution(Queue<Edge> pQ) {
        int result = 0;
        while(!pQ.isEmpty()) {
            Edge edge = pQ.poll();

            int v1 = edge.v1;
            int v2 = edge.v2;
            if (find(v1) == find(v2)) {
                continue;
            }
            union(v1, v2);
            result += edge.cost;
        }
        return result;
    }

    private static int find(int v) {
        if (v == unf[v]) {
            return v;
        }
        return unf[v] = find(unf[v]);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }
}

/* union & find 알고리즘

 */
/*
find() 값이 같다면 이미 같은 집합에 속해있는 것
이미 정점이 연결되어 트리로 구성되어 있는 상태
 */

/*
unf 배열 업데이트 과정
입력 : unf 배열값
2 9 8  : {0, 1, 9, 3, 4, 5, 6, 7, 8, 9}
2 3 10 : {0, 1, 9, 3, 4, 5, 6, 7, 8, 3}
1 2 12 : {0, 3, 3, 3, 4, 5, 6, 7, 8, 3}
8 9 15 : {0, 3, 3, 3, 4, 5, 6, 7, 3, 3}
2 8 17 : {0, 3, 3, 3, 4, 5, 6, 7, 3, 3}
3 4 18 : {0, 3, 3, 4, 4, 5, 6, 7, 3, 3}
1 9 25 : {0, 4, 3, 4, 4, 5, 6, 7, 3, 4}
7 8 35 : {0, 4, 3, 4, 4, 5, 6, 4, 4, 4}
5 7 38 : {0, 4, 3, 4, 4, 4, 6, 4, 4, 4}
4 5 44 : {0, 4, 3, 4, 4, 4, 6, 4, 4, 4}
3 7 55 : {0, 4, 3, 4, 4, 4, 6, 4, 4, 4}
5 6 60 : {0, 4, 3, 4, 6, 4, 6, 4, 4, 4}
 */

/*
그래프와 트리 차이점
- 그래프는 사이클이 존재할 수 있지만, 트리는 사이클이 존재하지 않는다.
 */
