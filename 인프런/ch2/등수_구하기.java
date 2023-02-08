package 인프런.ch2;

import java.util.*;

public class 등수_구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] input = new int[size];

        for(int i = 0; i < size; i++) {
            input[i] = in.nextInt();
        }

        for(int i = 0; i < size; i ++) {
            int score = 1;
            for(int num : input) {
                if(input[i] != num && input[i] < num) {
                    score++;
                }
            }
            System.out.print(score + " ");
        }
    }
}
