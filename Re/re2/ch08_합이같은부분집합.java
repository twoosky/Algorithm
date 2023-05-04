package Re.re2;

import java.util.*;

public class ch08_합이같은부분집합 {
    private static String answer = "NO";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(calculate(arr));
    }

    private static String calculate(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        if (sum % 2 != 0) return "NO";
        else {
            dfs(0, 0, "", sum / 2, arr);
            return answer;
        }
    }

    private static void dfs(int idx, int total, String result, int sum, int[] arr) {
        if (idx >= arr.length || total > sum || answer.equals("YES")) {
            return;
        }

        if (total == sum) {
            answer = "YES";
            return;
        }

        dfs(idx + 1, total + arr[idx], result + arr[idx] + " " , sum, arr);
        dfs(idx + 1, total, result, sum, arr);
    }
}
