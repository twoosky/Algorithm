package 인프런.ch8;

import java.util.*;

public class 순열_조합_차이 {
    private static int n;
    private static int m;
    private static int[] combi;
    private static int[] perm;
    private static boolean[] visited;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        combi = new int[m];
        perm = new int[m];
        visited = new boolean[n + 1];

        System.out.println("====== 조합(Combination) =====");
        combi(0, 1);
        System.out.println("====== 순열(Permutation) =====");
        permutation(0);
    }

    private static void combi(int depth, int start) {
        if (depth == m) {
            for(int num : combi) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++) {
            combi[depth] = i;
            combi(depth + 1, i + 1);
        }
    }

    private static void permutation(int depth) {
        if (depth == m) {
            for(int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (!visited[i]) {
                perm[depth] = i;
                visited[i] = true;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}

/*
❶ 순열: 서로 다른 n개에서 순서를 생각해 r개를 선택하는 것, (1 2)와 (2 1)을 다른 것이라 취급
❷ 조합: 서로 다른 n개에서 순서를 생각하지 않고 r개를 선택하는 것, (1 2)와 (2 1)을 같은 것이라 취급
 */

/*
입력 예제
4 2

출력 예제
====== 조합(Combination) =====
1 2
1 3
1 4
2 3
2 4
3 4
====== 순열(Permutation) =====
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
 */