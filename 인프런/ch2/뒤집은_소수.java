package 인프런.ch2;

import java.util.*;

public class 뒤집은_소수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        for(int i = 0; i < size; i++) {
            int num = Integer.parseInt(new StringBuilder(in.next()).reverse().toString());
            boolean flag = true;
            if (num == 1) {
                flag = false;
            }
            for(int j = 2; j < num; j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(num + " ");
            }
        }
    }
}
