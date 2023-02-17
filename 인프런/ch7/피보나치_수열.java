package 인프런.ch7;

import java.util.*;

public class 피보나치_수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] fibo = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            System.out.print(solution(fibo, i) + " ");
        }
    }

    private static int solution(int[] fibo, int n) {
        if (n == 1 || n == 2) {
            fibo[n] = 1;
            return fibo[n];
        }

        if(fibo[n] != 0) {
            return fibo[n];
        }
        else {
            fibo[n] = solution(fibo, n-1) + solution(fibo, n-2);
            return fibo[n];
        }
    }
}
