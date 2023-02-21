package 인프런.ch10;

import java.util.*;

public class 최대_부분_증가수열_Combination {
    private static int n;
    private static int[] arr;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < n; i++) {
            combi(i, 0);
        }
        System.out.print(result);
    }

    private static void combi(int start, int length) {
        boolean flag = true;

        for(int i = start + 1; i < n; i++) {
            if (arr[start] < arr[i]) {
                flag = false;
                combi(i, length + 1);
            }
        }
        if(flag) {
            result = Math.max(result, length + 1);
        }
    }
}

/*
Combination을 사용해 풀이시 Timeout 발생
- 정석 풀이는 DP를 사용한 방식이다.
 */
