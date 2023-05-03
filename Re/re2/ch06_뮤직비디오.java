package Re.re2;

import java.util.*;

public class ch06_뮤직비디오 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        int start = arr[n-1];
        int end = sum;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (count(arr, mid) <= m) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.print(result);
    }

    private static int count(int[] arr, int mid) {
        int sum = 0;
        int cnt = 1;  // 마지막 남는 거 고려
        for(int num : arr) {
            sum += num;
            if (sum > mid) {
                sum = num;
                cnt++;
            }
        }
        return cnt;
    }
}
