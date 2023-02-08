package 인프런.ch2;

import java.util.*;

public class 소수_에라토스테네스_체 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] result = new int[size + 1];
        result[0] = 1;
        result[1] = 1;

        int count = 0;

        for(int i = 2; i < size; i++) {
            if (result[i] == 0) {
                count++;
            }
            for(int j = i+1; j <= size; j++) {
                if (j % i == 0) {
                    result[j] = 1;
                }
            }
        }
        System.out.print(count);
    }
}
