package 인프런.ch6;

import java.util.*;

public class 뮤직비디오 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.print(solution(arr, n, m));
    }

    private static int solution(int[] arr, int n, int m) {
        int start = arr[n-1];
        int end = Arrays.stream(arr).sum();
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            int count = count(arr, mid);
            if (count <= m) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    // 왜 count가 1일까
    private static int count(int[] arr, int capacity) {
        int sum = 0;
        int count = 1;
        for(int num : arr) {
            sum += num;
            if (sum > capacity) {
                count++;
                sum = num;
            }
        }
        return count;
    }
}
