package 인프런.ch1;

import java.util.*;

public class 문장_속_단어 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] str = input.split(" ");

        String result = "";

        for(String word : str) {
            if (result.length() < word.length()) {
                result = word;
            }
        }

        System.out.print(result);
    }
}
