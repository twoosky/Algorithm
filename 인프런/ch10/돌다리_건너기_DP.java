package 인프런.ch10;

import java.util.Scanner;

public class 돌다리_건너기_DP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 2];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n + 2; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n + 1]);
    }
}
