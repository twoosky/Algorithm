package Re.re2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ch06_LRU {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (dq.size() < s) {
                dq.addFirst(num);
                continue;
            }
            if (!dq.contains(num)) {
                dq.removeLast();
                dq.addFirst(num);
            } else {
                dq.remove(num);
                dq.addFirst(num);
            }
        }

        for(Integer num : dq) {
            System.out.print(num + " ");
        }
    }
}
