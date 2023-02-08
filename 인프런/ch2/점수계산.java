package 인프런.ch2;

import java.util.*;

public class 점수계산 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int result = 0;
        int score = 0;

        for(int i = 0; i < size; i++) {
            int num = in.nextInt();
            if (num == 1) {
                score ++;
                result += score;
            } else {
                score = 0;
            }
        }
        System.out.print(result);
    }
}
