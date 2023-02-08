package 인프런.ch1;

import java.util.*;

public class 특정_문자_뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] input = in.nextLine().toCharArray();
        int lt = 0;
        int rt = input.length - 1;

        while(lt < rt) {
            if (!Character.isAlphabetic(input[lt])) lt++;
            else if (!Character.isAlphabetic(input[rt])) rt--;
            else {
                char tmp = input[lt];
                input[lt] = input[rt];
                input[rt] = tmp;
                lt++;
                rt--;
            }
        }

        String result = String.valueOf(input);
        System.out.print(result);
    }
}
