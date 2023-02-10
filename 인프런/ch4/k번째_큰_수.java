package 인프런.ch4;

import java.util.*;

public class k번째_큰_수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Set<Integer> result = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int r = j + 1; r < n; r++) {
                    if(r == j) break;
                    result.add(arr[i] + arr[j] + arr[r]);
                }
            }
        }

        if(result.size() < k) {
            System.out.print(-1);
        } else {
            int count = 0;
            for(int num : result) {
                count++;
                if(count == k) {
                    System.out.print(num);
                }
            }
        }
    }
}
