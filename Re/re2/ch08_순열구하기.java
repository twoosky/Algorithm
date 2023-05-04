package Re.re2;

import java.util.Scanner;

public class ch08_순열구하기 {
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        result = new int[m];
        visited = new boolean[n];

        dfs(0, m, arr);
    }

    private static void dfs(int depth, int m, int[] arr) {
        if (depth == m) {
            print();
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!visited[i]) {
                result[depth] = num;
                visited[i] = true;
                dfs(depth + 1, m, arr);
                visited[i] = false;
            }
        }
    }

    private static void print() {
        for(int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
