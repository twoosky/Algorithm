package Re.re2;

import java.util.Scanner;

public class ch08_조합구하기 {
    private static int[] result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        result = new int[m];

        dfs(0, 0, n, m);
    }

    private static void dfs(int idx, int depth, int n, int m) {
        if (depth == m) {
            print();
            return;
        }

        for(; idx < n; idx++) {
            result[depth] = idx + 1;
            dfs(idx + 1, depth + 1, n, m);
        }
    }

    private static void print() {
        for(int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
