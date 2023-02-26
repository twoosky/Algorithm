package Re;

import java.util.Arrays;
import java.util.Scanner;

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

        int start = arr[0];
        int result = 0;
        int end = arr[arr.length - 1];
        while(start <= end) {
            int mid = (start + end) / 2;
            if(check(mid, arr) >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static int check(int mid, int[] arr) {
        int pos = arr[0];
        int count = 1;  // 말 마리 수 (arr[0]에서부터 시작하므로 count 1로 초기화)
        for(int i = 1; i < arr.length; i++) {
            int d = arr[i] - pos;
            if (d >= mid) {
                count++;
                pos = arr[i];
            }
        }
        return count;
    }
}
