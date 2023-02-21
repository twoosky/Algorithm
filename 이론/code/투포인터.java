package 이론.code;

import java.util.*;

public class 투포인터 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int result = 0;
        int point = 1;
        int sum = 0;
        for(int i = 1; i < n; i++) {
            sum += i;
            while(sum > n) {
                sum -= point;
                point++;
            }
            if (sum == n) {
                result++;
            }
        }

        System.out.println(result);
    }
}
