package 인프런.ch8;

import java.util.*;

public class 조합수_메모이제이션 {
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        arr = new int[n + 1][n + 1];

        dfs(n, r);
        System.out.print(arr[n][r]);
    }

    private static int dfs(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        if (arr[n][r] != 0) {
            return arr[n][r];
        }

        return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }
}

/* 조합
nCr = n-1Cr-1 + n-1Cr
nCn, nC0 은 1이다.
 */

/*
입력 예제
5 3
출력 예제
10
 */

/*
입력 예제
33 19
출력 예제
818809200
 */