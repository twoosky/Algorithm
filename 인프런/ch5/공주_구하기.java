package 인프런.ch5;

import java.util.*;

public class 공주_구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }

        int pos = 0;
        while(isDone(arr)) {
            int i = pos;
            while(i < pos + k) {
                if(arr[pos] != 1) {

                }
            }
            arr[pos] = 1;
            pos += k;
            if (pos >= arr.length) {
                pos -= arr.length;
            }
        }

        for(int num : arr) {
            if(num == 0) {
                System.out.print(num);
            }
        }
    }

    private static boolean isDone(int[] arr) {
        int count = 0;
        for(int num : arr) {
            if(num == 0) {
                count++;
            }
        }
        return count == 1;
    }
}
