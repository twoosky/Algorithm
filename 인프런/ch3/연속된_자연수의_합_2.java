package 인프런.ch3;

import java.util.*;

public class 연속된_자연수의_합_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // count: 연속된 자연수 개수
        int count = 1, result = 0;
        n--;
        while (n > 0) {
            count++;
            n = n - count;
            if (n % count == 0) {
                result++;
            }
        }
        System.out.print(result);
    }
}
