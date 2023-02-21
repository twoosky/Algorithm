package 이론.code;

import java.util.*;

public class 조합_값구하기 {
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 숫자 개수
        int r = in.nextInt();  // 뽑을 개수
        dp = new int[n + 1][r + 1];

        System.out.print(combi(n, r));
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
