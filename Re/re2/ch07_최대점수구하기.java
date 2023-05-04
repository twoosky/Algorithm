package Re.re2;

import java.util.*;

public class ch07_최대점수구하기 {
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        dfs(0, 0, 0, arr, m);
        System.out.println(result);
    }

    private static void dfs(int idx, int time, int score, int[][] arr, int m) {
        if (time > m) {
            return;
        }

        if (idx == arr.length) {
            result = Math.max(result, score);
            return;
        }

        dfs(idx + 1, time + arr[idx][1], score + arr[idx][0], arr, m);
        dfs(idx + 1, time, score, arr, m);
    }
}
