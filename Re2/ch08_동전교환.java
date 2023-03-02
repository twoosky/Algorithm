package Re2;

import java.util.*;

public class ch08_동전교환 {
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());
        dfs(0, 0, m, arr);
        System.out.println(result);
    }

    private static void dfs(int depth, int sum, int m, Integer[] arr) {
        if (sum > m) {
            return;
        }
        if (depth >= result) {
            return;
        }
        if (sum == m) {
            result = Math.min(result, depth);
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            dfs(depth + 1, sum + arr[i], m, arr);
        }
    }
}
