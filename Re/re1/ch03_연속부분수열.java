package Re.re1;

import java.util.*;

public class ch03_연속부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int count = 0;
        int sum = 0;
        int lt = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < m) {
                continue;
            }
            while(sum > m) {
                sum -= arr[lt];
                lt++;
            }
            if (sum == m) {
                sum -= arr[lt];
                lt++;
                count++;
            }
        }
        System.out.print(count);
    }
}
