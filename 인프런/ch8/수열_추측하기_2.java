package 인프런.ch8;

import java.util.*;

public class 수열_추측하기_2 {
    private static int n;
    private static int f;
    private static int[] numbers;
    private static boolean[] visited;
    private static int[][] dp;
    private static int[] combi;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        numbers = new int[n];
        visited = new boolean[n + 1];
        dp = new int[n][n];
        combi = new int[n];

        for(int i = 0; i < n; i++) {
            combi[i] = combi(n - 1, i);
        }

        dfs(0);
        for(int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += (numbers[i] * combi[i]);
            }
            if (sum == f) {
                flag = true;
            }
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (flag) {
                    return;
                }
                numbers[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int combi(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
