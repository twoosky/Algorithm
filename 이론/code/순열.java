package 이론.code;

import java.util.*;

public class 순열 {
    private static int n;
    private static int r;
    private static int[] result;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();  // 숫자 개수
        r = in.nextInt();  // 뽑을 개수
        result = new int[r];
        visited = new boolean[n + 1];

        permutation(0);
    }

    private static void permutation(int depth) {
        if (depth == r) {
            for(int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result[depth] = i;
                visited[i] = true;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
