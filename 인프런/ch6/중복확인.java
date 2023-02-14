package 인프런.ch6;

import java.util.*;

public class 중복확인 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(solution(n, arr));
    }

    // 인프런 풀이
    private static String solution(int n, int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i+1]) {
                return "D";
            }
        }
        return "U";
    }

    // 내 풀이
    private static String solution2(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr) {
            set.add(num);
        }

        if(arr.length != set.size()) {
            return "D";
        }
        return "U";
    }
}
