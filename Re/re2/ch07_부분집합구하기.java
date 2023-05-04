package Re.re2;

import java.util.*;


public class ch07_부분집합구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        dfs(1, "", n);
    }

    private static void dfs(int idx, String result, int n) {
        if (idx > n) {
            System.out.println(result);
            return;
        }

        dfs(idx + 1, result + idx + " ", n);
        dfs(idx + 1, result, n);
    }
}
