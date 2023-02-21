package 인프런.ch10;

import java.util.Scanner;

public class 최대_부분_증가수열_DP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = 1;

        int result = 0;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}

/*
5 3 7 8 6 2 9 4

dp 배열
{1, 0, 0, 0, 0, 0, 0, 0}
{1, 1, 0, 0, 0, 0, 0, 0}
{1, 1, 2, 0, 0, 0, 0, 0}
{1, 1, 2, 3, 0, 0, 0, 0}  dp[3] = 8보다 작은 (5,3,7)의 dp값 중 중 최대값 + 1
{1, 1, 2, 3, 2, 0, 0, 0}  dp[4] = 6보다 작은 (3)의 dp값 + 1
{1, 1, 2, 3, 2, 1, 0, 0}  dp[5] = 2보다 작은 값이 없으므로 1
{1, 1, 2, 3, 2, 1, 4, 0}  dp[6] = 9보다 작은 (5,3,7,8,6,2)의 dp값 중 최대값인 3 + 1
{1, 1, 2, 3, 2, 1, 4, 2}  dp[7] = 4보다 작은 (3,2)의 dp값 중 최대값인 1 + 1
 */