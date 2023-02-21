package 인프런.ch10;

import java.util.*;

public class 동전교환_냅색알고리즘 {
    private static int[] arr;
    private static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        m = in.nextInt();

        System.out.println(knapsack());
    }

    private static int knapsack() {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int coin : arr) {
            for(int j = coin; j <= m; j++) {
                int tmp = dp[j - coin] + 1;
                if (dp[j] > tmp) {
                    dp[j] = tmp;
                }
            }
        }
        return dp[m];
    }
}


/*
dp[i] : i 금액을 만드는데 드는 최소 동전개수

동전 금액
1 : { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }
2 : { 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8 }
5 : { 0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3, 3, 4, 4, 3 }
 */