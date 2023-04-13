package 그리디;

import java.util.Scanner;

public class PFCT_곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.next().split("");

        int result = Integer.parseInt(input[0]);

        for(int i = 1; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            int tmp = result + num;
            int tmp2 = result * num;
            result = Math.max(tmp, tmp2);
        }

        System.out.print(result);
    }
}
