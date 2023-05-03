package Re.re2;

import java.util.*;

public class ch06_마구간정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr[arr.length - 1];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;   // 말 사이의 거리
            if (count(arr, mid) >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static int count(int[] arr, int mid) {
        int count = 1;
        int pos = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int dis = arr[i] - pos;
            if (dis >= mid) {
                pos = arr[i];
                count++;
            }
        }
        return count;
    }
}
