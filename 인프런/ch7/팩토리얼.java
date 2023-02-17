package 인프런.ch7;

import java.util.*;

public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.print(solution(n));
    }

    private static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        return solution(n - 1) * n;
    }
}
