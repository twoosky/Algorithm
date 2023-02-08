package 인프런.ch1;

import java.util.*;

public class 대소문자_변환 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        StringBuilder stringBuilder = new StringBuilder();

        for(char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                stringBuilder.append(Character.toUpperCase(c));
            } else {
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        String result = stringBuilder.toString();

        System.out.print(result);
    }
}
