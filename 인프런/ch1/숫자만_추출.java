package 인프런.ch1;

import java.util.*;

public class 숫자만_추출 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String pick = input.replaceAll("[^0-9]", "");
        System.out.print(Integer.parseInt(pick));
    }
}
