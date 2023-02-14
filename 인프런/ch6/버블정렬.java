package 인프런.ch6;

import java.util.*;

public class 버블정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/* 버블정렬
- 양 옆의 값을 비교해 큰 값을 오른쪽으로 이동시키며 정렬하는 알고리즘
- 시간 복잡도 : O(n^2)
 */
