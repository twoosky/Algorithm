package Re2;

import java.util.*;

public class ch08_조합 {
    private static int[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        dp = new int[n + 1][r + 1];

        System.out.println(combi(n, r));
    }

    private static int combi(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        if (dp[n][r] != 0) {
            return dp[n][r];
        }
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}
