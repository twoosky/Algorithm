package 인프런.ch8;

import java.util.*;

public class 순열_구하기 {
    private static int[] arr;
    private static int[] result;
    private static boolean[] visited;
    private static int m;
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();  // 뽑는 횟수
        result = new int[m];
        arr = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        dfs(0);
    }

    private static void dfs(int pickCnt) {
        if (pickCnt == m) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int num : result) {
                stringBuilder.append(num + " ");
            }
            System.out.println(stringBuilder);
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                result[pickCnt] = arr[i];
                visited[i] = true;
                dfs(pickCnt + 1);
                visited[i] = false;
            }
        }
    }
}

/* 입력 예제
3 2
3 6 9
 */