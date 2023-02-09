package 인프런.ch3;

import java.util.*;

public class 연속된_자연수의_합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0, sum = 0, p = 1;
        for(int i = 1; i < n; i++) {
            sum += i;
            while(sum > n) {
                sum -= p;
                p++;
            }
            if(sum == n) {
                count++;
                sum -= p;
                p++;
            }
        }
        System.out.print(count);
    }
}
