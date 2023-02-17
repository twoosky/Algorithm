package 이분탐색;

import java.util.*;

public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        long n = in.nextInt();
        long[] arr = new long[k];
        for(int i = 0; i< k; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[k-1];
        long result = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            if(count(arr, mid) >= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(result);
    }

    private static long count(long[] arr, long mid) {
        long count = 0;
        for(long num : arr) {
            count += (num / mid);
        }
        return count;
    }
}
