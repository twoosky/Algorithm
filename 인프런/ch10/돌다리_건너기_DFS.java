package 인프런.ch10;

import java.util.*;

public class 돌다리_건너기_DFS {
    private static int n;
    private static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int step) {
        if (step >= n) {
            result += 1;
            return;
        }

        dfs(step + 1);
        dfs(step + 2);
    }
}
