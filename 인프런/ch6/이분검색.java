package 인프런.ch6;

import java.util.*;

public class 이분검색 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        System.out.print(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (m == arr[mid]) {
                return mid + 1;
            } else if (m < arr[mid]) {
                end = mid - 1;
            } else if (m > arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}

/* 이진 탐색
- 찾으려는 데이터와 중간점(mid) 위치에 있는 데이터를 반복적으로 비교해 데이터를 탐색하는 알고리즘
- 탐색 범위를 절반식 좁혀가며 데이터 탐색, start, mid, end 값 사용
- 시간 복잡도 : O(logN)

1. 탐색 데이터가 mid 데이터보다 작으면 end = mid - 1
2. 탐색 데이터가 mid 데이터보다 크면 start = mid + 1
3. 탐색 데이터와 mid 데이터가 같으면 mid 반환
 */
