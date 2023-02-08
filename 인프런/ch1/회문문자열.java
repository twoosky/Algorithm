package 인프런.ch1;

import java.util.*;

public class 회문문자열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toLowerCase();

        System.out.print(solution2(input));
    }

    private static String solution2(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        String reverse = stringBuilder.reverse().toString();
        if (reverse.equals(input)) {
            return "YES";
        }
        return "NO";
    }

    private static String solution(String input) {
        String[] str = input.split("");
        int lt = 0;
        int rt = str.length - 1;

        while(lt < rt) {
            if (!str[lt].equals(str[rt])) {
                return "NO";
            }
            lt++;
            rt--;
        }
        return "YES";
    }
}
