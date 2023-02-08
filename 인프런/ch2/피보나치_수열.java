package 인프런.ch2;

import java.util.*;

public class 피보나치_수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[] result = new int[size];
        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i < size; i ++) {
            result[i] = result[i-1] + result[i-2];
        }

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
