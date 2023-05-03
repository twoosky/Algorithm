package Re.re2;

import java.util.Scanner;

public class ch03_최대길이연속부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int count = 0;
        int lt = 0;
        int result = 0;

        for(int rt = 0; rt < arr.length; rt++) {
            if (arr[rt] == 0) {
                count++;
            }

            while (count > k) {
                if (arr[lt] == 0) {
                    count--;
                }
                lt++;
            }

            result = Math.max(result, rt - lt + 1);
        }
        System.out.println(result);
    }
}
