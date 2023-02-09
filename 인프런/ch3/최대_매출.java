package 인프런.ch3;

import java.util.*;

public class 최대_매출 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int max = 0, sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = sum;
        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i-k]);
            if (sum > max) {
                max = sum;
            }
        }

        System.out.print(max);
    }
}
