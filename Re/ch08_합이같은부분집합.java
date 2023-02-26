package Re;

import java.util.*;

public class ch08_합이같은부분집합 {
    private static String result = "NO";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sum = 0;
        for(int num : arr) {
            sum += num;
        }

        if (sum % 2 != 0) {
            System.out.print("NO");
        } else {
            dfs(0, 0, sum / 2, arr);
            System.out.println(result);
        }
    }

    private static void dfs(int s, int sum, int num, int[] arr) {
        if (s == arr.length || sum > num) {
            return;
        }

        if (sum == num) {
            result = "YES";
            return;
        }

        dfs(s + 1, sum + arr[s], num, arr);
        dfs(s + 1, sum, num, arr);
    }
}
