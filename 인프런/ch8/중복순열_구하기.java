package 인프런.ch8;

import java.util.*;

public class 중복순열_구하기 {
    private static int m;
    private static int n;
    private static int[] result;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();  // 1 ~ N 구슬 번호
        m = in.nextInt();  // 뽑는 횟수
        result = new int[m];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < depth; i++) {
                stringBuilder.append(result[i] + " ");
            }
            System.out.println(stringBuilder);
            return;
        }

        for(int i = 1; i <= n; i++) {
            result[depth] = i;
            dfs(depth + 1);
        }
    }
}
