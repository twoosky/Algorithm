package DFS_BFS;

import java.util.*;

class PRO_네트워크_UnionFind {
    private static int[] unf;

    public int solution(int n, int[][] computers) {
        unf = new int[n];

        // 1. unf 배열 초기화 {0, 1, 2}
        for(int i = 0; i < n; i++) {
            unf[i] = i;
        }

        // 2. 연결되어 있는 노드들은 같은 집합으로 묶기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 3. 집합을 찾고 find(num), 집합의 개수 반환 tmp.size()
        List<Integer> tmp = new ArrayList<>();
        for(int num : unf) {
            System.out.print(num + " ");
            if (!tmp.contains(find(num))) {
                tmp.add(find(num));
            }
        }

        int answer = tmp.size();
        return answer;
    }

    private int find(int v) {
        if (unf[v] == v) {
            return v;
        }
        else {
            return unf[v] = find(unf[v]);
        }
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

}