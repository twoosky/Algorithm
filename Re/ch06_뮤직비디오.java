package Re;

import java.util.*;

import java.util.Scanner;

public class ch06_뮤직비디오 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int num : arr) {
            max += num;
            min = Math.min(num, min);
        }

        int start = min;
        int end = max;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, m, arr)) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

    private static boolean check(int mid, int m, int[] arr) {
        int count = 0;
        int sum = 0;
        for (int j : arr) {
            sum += j;
            if (sum > mid) {
                count++;
                sum = j;
            } else if (sum == mid) {
                count++;
                sum = 0;
            }
        }
        if (sum != 0) {
            count++;
        }
        if (count > m) {  // DVD 크기가 너무 작은 경우
            return false;
        }
        return true;  // DVD 크기가 크거나 알맞은 경우
    }
}
