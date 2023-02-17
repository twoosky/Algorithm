package 인프런.ch8;

import java.util.*;

public class 조합_구하기 {
    private static int[] result;
    private static int m;
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        result = new int[m];

        combi(0, 1);
    }

    private static void combi(int depth, int start) {
        if (depth == m) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int num : result) {
                stringBuilder.append(num + " ");
            }
            System.out.println(stringBuilder);
            return;
        }

        for(int i = start; i <= n; i++) {
            result[depth] = i;
            combi(depth + 1, i + 1);
        }


    }
}

/*
입력 예제
4 2
출력 예제
1 2
1 3
1 4
2 3
2 4
3 4
 */