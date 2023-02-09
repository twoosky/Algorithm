package 인프런.ch3;

import java.util.*;

public class 연속_부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int count = 0, sum = 0, p = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            while(sum > m) {
                sum -= arr[p];
                p++;
            }
            if(sum == m) {
                count++;
                sum -= arr[p];
                p++;
            }
        }
        System.out.print(count);
    }
}
