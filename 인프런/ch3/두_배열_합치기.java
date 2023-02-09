package 인프런.ch3;

import java.util.*;

public class 두_배열_합치기 {
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

        int p1 = 0, p2 = 0;
        List<Integer> result = new ArrayList<>();
        while(p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                result.add(arr1[p1]);
                p1++;
            } else {
                result.add(arr2[p2]);
                p2++;
            }
        }
        add(p1, n, arr1, result);
        add(p2, m, arr2, result);

        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    private static void add(int p, int l, int[] arr, List<Integer> result) {
        while(p < l) {
            result.add(arr[p]);
            p++;
        }
    }
}
