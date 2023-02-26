package Re;

import java.util.*;

public class ch08_동전교환 {
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

        dfs(0, 0, m, arr);
        System.out.println(result);
    }

    private static void dfs(int sum, int depth, int m, Integer[] arr) {
        if (sum > m) {
            return;
        }

        if (result < depth) {
            return;
        }

        if (sum == m) {
            result = depth;
            return;
        }

        for(int num : arr) {
            dfs(sum + num, depth + 1, m, arr);
        }
    }
}
