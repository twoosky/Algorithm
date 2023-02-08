package 인프런.ch2;

import java.util.*;

public class 가위바위보 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];

        for(int i = 0; i < size; i++) {
            a[i] = in.nextInt();
        }
        for(int i = 0; i < size; i++) {
            b[i] = in.nextInt();
        }

        for(int i = 0; i < size; i++) {
            System.out.println(solution(a[i], b[i]));
        }
    }

    private static String solution(int a, int b) {
        if (a == 1 && b == 2) {
            return "B";
        } else if (a == 3 && b == 1) {
            return "B";
        } else if (a == 2 && b == 3) {
            return "B";
        } else if (a == b) {
            return "D";
        } else {
            return "A";
        }
    }
}
