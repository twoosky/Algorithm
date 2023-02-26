package Re;

import java.util.*;

public class ch08_수열추측하기 {
    private static int[][] dp;
    private static int[] result;
    private static int[] combi;
    private static boolean[] visited;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        combi = new int[n];
        result = new int[n];
        visited = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            dp = new int[n][n];
            combi[i] = combi(n - 1, n - i - 1);
        }

        dfs(0, n, m);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    private static void dfs(int depth, int n, int m) {
        if (depth == n) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += result[i] * combi[i];
            }
            if (sum == m) {
                flag = true;
            }
            return;
        }
        for(int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (flag) {
                    return;
                }
                result[depth] = i;
                visited[i] = true;
                dfs(depth + 1, n, m);
                visited[i] = false;
            }
        }
    }

    private static int combi(int n, int r){
        if (n == r || r == 0) {
            return 1;
        }
        if (dp[n][r] != 0) {
            return dp[n][r];
        }
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
