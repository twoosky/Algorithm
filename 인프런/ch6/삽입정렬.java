package 인프런.ch6;

import java.util.*;

public class 삽입정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {  // j 가 삽입하고자 하는 값의 인덱스
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else {
                    break;
                }
            }
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/* 삽입 정렬
- 데이터를 하나씩 확인하며, 데이터를 적절한 위치에 삽입하는 알고리즘
- 해당 데이터의 앞까지의 데이터는 이미 정렬되어 있다고 가정
- 시간 복잡도(최선): O(n)
- 시간 복잡도(최악): O(n^2)
 */
