package 인프런.ch8;

import java.util.*;

public class 최대점수_구하기 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();  // 점수
            arr[i][1] = in.nextInt();  // 걸리는 시간
        }

        dfs(0, 0, 0);
        System.out.print(result);
    }

    private static void dfs(int nodeIdx, int score, int time) {
        if (time > m) {
            return;
        }

        if (nodeIdx == n) {
            result = Math.max(result, score);
            return;
        }

        // 해당 문제를 푸는 경우
        dfs(nodeIdx + 1, score + arr[nodeIdx][0], time + arr[nodeIdx][1]);
        // 해당 문제를 풀지 않는 경우
        dfs(nodeIdx + 1, score, time);
    }
}
