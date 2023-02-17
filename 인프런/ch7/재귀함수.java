package 인프런.ch7;

import java.util.*;

public class 재귀함수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    private static void solution(int n) {
        if (n == 0) {
            return;
        } else {
            solution(n - 1);
            System.out.print(n + " ");
        }
    }
}
