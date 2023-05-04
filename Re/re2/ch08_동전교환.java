package Re.re2;

import java.util.*;

public class ch08_동전교환 {
    private static boolean flag = false;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();

        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        dfs(0, 0, arr, m);
        System.out.println(result);
    }

    private static void dfs(int depth, int sum, Integer[] arr, int m) {
        if (depth > m || flag) {
            return;
        }

        if (sum == m) {
            result = depth;
            flag = true;
            return;
        }

        for(int num : arr) {
            dfs(depth + 1, sum + num, arr, m);
        }
    }
}
