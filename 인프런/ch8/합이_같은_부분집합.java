package 인프런.ch8;

import java.util.*;

public class 합이_같은_부분집합 {
    private static int[] arr;
    private static int total = 0;
    private static boolean flag = false;
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            total += arr[i];
        }

        dfs(0, 0);
        if(flag) System.out.print("YES");
        else System.out.print("NO");
    }

    private static void dfs(int nodeIdx, int sum) {
        // flag가 true일 때 즉, 합이 같은 부분집합을 찾으면 탐색을 종료하기 위한 로직
        if (flag) {
            return;
        }

        if (sum > (total / 2) || nodeIdx == n) {
            return;
        }

        // 홀수인 경우 몫은 같으나 나머지가 있으므로 나머지 값도 0인지 검사
        if (sum == (total / 2) && (total % sum) == 0) {
            flag = true;
            return;
        }

        // 해당 원소를 부분집합에 포함하는 경우
        dfs(nodeIdx + 1, sum + arr[nodeIdx]);
        // 해당 원소를 부분집합에 포함하지 않는 경우
        dfs(nodeIdx + 1, sum);
    }
}
