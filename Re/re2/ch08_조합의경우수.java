package Re.re2;

import java.util.Scanner;

public class ch08_조합의경우수 {
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        dp = new int[n + 1][r + 1];

        combination(n, r);
        System.out.println(dp[n][r]);
    }

    private static int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        if(dp[n][r] != 0) {
            return dp[n][r];
        }

        return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
}
