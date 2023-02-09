package 인프런.ch3;

import java.util.*;

public class 공통_원소_구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }

        for(int num : solution(n, m, arr1, arr2)) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr1[p1] == arr2[p2]) {
                result.add(arr1[p1]);
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return result;
    }
}
