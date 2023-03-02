package Re2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class ch03_최대길이연속부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int result = 0;
        int sum = 0;
        int lt = 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            sum += 1;
            if (arr[i] == 0) {
                if (count >= m) {
                    int idx = q.poll();
                    sum -= (idx - lt);
                    lt = idx;
                }
                count++;
                q.offer(i + 1);
            }
            result = Math.max(result, sum);
        }
        System.out.print(result);
    }
}
