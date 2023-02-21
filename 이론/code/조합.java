package 이론.code;

import java.util.*;

public class 조합 {
    private static int n;
    private static int r;
    private static int[] result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();  // 숫자 개수
        r = in.nextInt();  // 뽑을 개수
        result = new int[r];

        combination(1, 0);
    }

    private static void combination(int start, int depth) {
        if (depth == r) {
            for(int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++) {
            result[depth] = i;
            combination(i + 1, depth + 1);
        }
    }
}
