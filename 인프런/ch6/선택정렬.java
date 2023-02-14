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

/* 선택정렬 (이코테 157p)
- 매번 가장 작은 데이터를 선택해 앞의 데이터와 교환해 정렬하는 알고리즘
- 시간 복잡도 : O(n^2)
- 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고,
  그다음 작은 데이터를 선택해 앞에서 두 번재 데이터와 바꾸는 과정 반복
 */
