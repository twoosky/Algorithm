package Re2;

import java.util.*;

public class ch06_마구간정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int start = arr[0];
        int end = arr[arr.length - 1];
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, arr) >= m) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    // mid가 가장 가까운 두 말의 거리 최대값
    private static int check(int mid, int[] arr) {
        int count = 1;
        int start = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if ((arr[i] - start) >= mid) {
                count++;
                start = arr[i];
            }
        }
        return count;
    }
}
