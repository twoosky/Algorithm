package Re2;

import java.util.*;

public class ch08_합이같은부분집합 {
    private static String result = "NO";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            System.out.println("NO");
        } else {
            dfs(0, 0, sum / 2, arr);
            System.out.println(result);
        }
    }

    private static void dfs(int idx, int sum, int target, int[] arr) {
        if (sum > target || idx == arr.length) {
            return;
        }
        if (sum == target) {
            result = "YES";
            return;
        }

        dfs(idx + 1, sum, target, arr);
        dfs(idx + 1, sum + arr[idx], target, arr);
    }
}
