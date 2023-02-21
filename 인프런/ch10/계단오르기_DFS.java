package 인프런.ch10;

import java.util.*;

public class 계단오르기_DFS {
    private static int result = 0;
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dfs(0);
        System.out.print(result);
    }

    private static void dfs(int step) {
        if (step == n) {
            result += 1;
            return;
        }
        if (step > n) {
            return;
        }
        dfs(step + 1);
        dfs(step + 2);
    }
}
