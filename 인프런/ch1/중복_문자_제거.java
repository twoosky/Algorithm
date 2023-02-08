package 인프런.ch1;

import java.util.*;

public class 중복_문자_제거 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split("");
        StringBuilder stringBuilder = new StringBuilder();

        for(String str : input) {
            if (stringBuilder.indexOf(str) < 0) {
                stringBuilder.append(str);
            }
        }

        String result2 = stringBuilder.toString();
        System.out.print(result2);
    }
}
