package 인프런.ch6;

import java.util.*;

public class 마구간_정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in. nextInt();
        int c = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int start = arr[1] - arr[0];
        int end = arr[n - 1] - arr[0];
        int result = 0;
        while(start <= end) {
            int mid = (end + start) / 2;
            if (count(arr, mid) >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(result);
    }

    private static int count(int[] arr, int mid) {
        int endPoint = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] - endPoint >= mid) {
                count++;
                endPoint = arr[i];
            }
        }
        return count;
    }
}
