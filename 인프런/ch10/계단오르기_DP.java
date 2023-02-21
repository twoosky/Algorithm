package 인프런.ch10;

import java.util.*;

public class 계단오르기_DP {
    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
