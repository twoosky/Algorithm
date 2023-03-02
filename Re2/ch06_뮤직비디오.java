package Re2;

import java.util.*;

public class ch06_뮤직비디오 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            max += arr[i];
            min = Math.min(min, arr[i]);
        }

        int start = min;
        int end = max;
        int result = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, arr) <= m) {
                end = mid - 1;
                result = Math.min(mid, result);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static int check(int mid, int[] arr) {
        int sum = 0;
        int count = 0;
        for (int j : arr) {
            sum += j;
            if (sum > mid) {
                sum = j;
                count++;
            } else if (sum == mid) {
                sum = 0;
                count++;
            }
        }

        if (sum != 0) count++;
        return count;
    }
}
