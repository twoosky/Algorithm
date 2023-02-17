package 인프런.ch8;

import java.util.*;

public class 바둑이_승차 {
    private static int result;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        dfs(0, 0, c, n);
        System.out.print(result);
    }

    private static void dfs(int nodeIdx, int sum, int weight, int n) {
        if (sum > weight) {
            return;
        }

        if (nodeIdx == n) {
            result = Math.max(result, sum);
            return;
        }

        dfs(nodeIdx + 1, sum + arr[nodeIdx], weight, n);
        dfs(nodeIdx + 1, sum, weight, n);
    }
}
