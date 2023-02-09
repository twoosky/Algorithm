package 인프런.ch3;

import java.util.*;

public class 최대_길이_연속부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int lt = 0, max = 0, cnt = 0;
        for(int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;
            while(cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            max = Math.max(max, rt - lt + 1);
        }
        System.out.print(max);
    }
}
