package 인프런.ch7;

import java.util.*;

public class 부분집합_구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] check = new int[n + 1];

        dfs(n, 1, check);
    }

    private static void dfs(int n, int level, int[] check) {
        if (level > n) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 1; i < check.length; i++) {
                if (check[i] == 1) {
                    stringBuilder.append(i + " ");
                }
            }
            if (stringBuilder.length() > 0) {
                System.out.println(stringBuilder);
            }
            return;
        } else {
            check[level] = 1;
            dfs(n, level + 1, check);  // 해당 레벨 방문 하는 경우
            check[level] = 0;
            dfs(n, level + 1, check);  // 해당 레벨 방문 안하는 경우
        }
    }
}
