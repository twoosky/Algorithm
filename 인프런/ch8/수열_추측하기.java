package 인프런.ch8;

import java.util.*;

public class 수열_추측하기 {
    private static boolean[] visited;
    private static int[] combi, result;
    private static int[][] dy;
    private static int n;
    private static int f;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        result = new int[n];
        combi = new int[n];
        visited = new boolean[n + 1];
        dy = new int[n + 1][n + 1];

        for(int i = 0; i < n; i++) {
            combi[i] = combi(n-1, i);
        }

        dfs(0, 0);
    }

    private static void dfs(int depth, int sum) {
        if (flag) {
            return;
        }

        if (depth == n) {
            if (sum == f) {
                for(int num : result) {
                    System.out.print(num + " ");
                }
                flag = true;
            }
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1, sum + (result[depth] * combi[depth]));
                visited[i] = false;
            }
        }
    }

    private static int combi(int n, int r) {
        if(n == r || r == 0) {
            return 1;
        }

        if(dy[n][r] != 0) {
            return dy[n][r];
        }

        return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}
