package 인프런.ch9;

import java.util.*;

public class 친구인가 {
    private static int[] unf;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        unf = new int[n+1];
        for(int i = 0; i < n + 1; i++) {
            unf[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            union(a, b);
        }

        int friend1 = in.nextInt();
        int friend2 = in.nextInt();

        if (unf[friend1] == unf[friend2]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int find(int v) {
        if (v == unf[v]) {
            return v;
        }
        return unf[v] = find(unf[v]);
    }
}

/*
unf 배열 업데이트 과정

입력 : unf 배열값
1 2 : {1, 2, 3, 4, 5, 6, 7, 8, 9}
2 3 : {2, 3, 3, 4, 5, 6, 7, 8, 9}
3 4 : {2, 3, 4, 4, 5, 6, 7, 8, 9}
1 5 : {4, 4, 4, 5, 5, 6, 7, 8, 9}
6 7 : {4, 4, 4, 5, 5, 7, 7, 8, 9}
7 8 : {4, 4, 4, 5, 5, 7, 8, 8, 9}
8 9 : {4, 4, 4, 5, 5, 7, 8, 9, 9}
 */
