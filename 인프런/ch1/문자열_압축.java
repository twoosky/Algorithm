package 인프런.ch1;

import java.util.*;

public class 문자열_압축 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        String[] str = (input + " ").split("");
        int count = 1;

        for(int i = 0; i < str.length - 1; i++) {
            if (str[i].equals(str[i+1])) {
                count++;
            } else {
                stringBuilder.append(str[i]);
                if (count != 1) {
                    stringBuilder.append(count);
                }
                count = 1;
            }
        }
        System.out.print(stringBuilder);
    }
}
