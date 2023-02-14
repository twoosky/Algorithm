package 인프런.ch6;

import java.util.*;

public class 선택정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = tmp;
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
