package 인프런.ch8;

import java.util.*;

public class 동전교환 {
    private static int[] arr;
    private static int m;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n]; // 동전 종류
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        m = in.nextInt();   // 거슬러 줄 금액

        dfs(0, 0);
        System.out.print(result);
    }

    private static void dfs(int sum, int depth) {
        if (sum > m) {
            return;
        }

        // depth가 result보다 크다면 볼 필요가 없으므로 탐색 종료 조건 추가
        if (depth > result) {
            return;
        }

        if (sum == m) {
            result = depth;
            return;
        }

        // 최소 동전 개수이므로 큰 값의 동전부터 거슬러줘야함.
        for(int i = arr.length - 1; i >= 0; i--) {
            dfs(sum + arr[i], depth + 1);
        }
    }
}

/*
주의 사항
- depth가 result보다 작으면 더 이상 탐색할 필요가 없다. 탐색 종료 조건 추가 필수
- 최소 동전 개수이므로, 큰 값의 동전부터 탐색해야 시간 초과를 방지할 수 있다.
1. Integer[] arr = new Integer[n];
   Arrays.sort(arr, Collections.reverseOrder());
2. for(int i = arr.length - 1; i >= 0; i--)
 */