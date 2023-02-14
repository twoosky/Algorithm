package 인프런.ch6;

import java.util.*;

public class 장난꾸러기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

        for(int num : solution(n, arr)) {
            System.out.print(num + " ");
        }
    }

    // 인프런 풀이: 입력받은 배열과 정렬된 배열을 비교해 위치 탐색
    private static List<Integer> solution(int n, int[] arr) {
        int[] arr2 = arr.clone();
        Arrays.sort(arr);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(arr[i] != arr2[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }

    // 내 풀이: 얼렁뚱땅 하드코딩
    private static void solution2(int n, int[] arr) {
        int[] result = new int[2];
        int idx = 0;
        for(int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i+1]) {
                if (idx == 0) result[idx] = i + 1;
                else result[idx] = i + 2;
                idx++;
            }
        }

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}

