package 인프런.ch1;

import java.util.*;

public class 암호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String input = in.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < num; i++) {
            String str = input.substring(0, 7);
            String tmp = str.replace("*", "0").replace("#", "1");
            int number = Integer.parseInt(tmp, 2);
            stringBuilder.append((char) number);
            input = input.substring(7);
        }

        System.out.print(stringBuilder);
    }
}
