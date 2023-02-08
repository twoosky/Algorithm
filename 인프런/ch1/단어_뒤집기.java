package 인프런.ch1;

import java.util.*;

public class 단어_뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<String> input = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            input.add(in.next());
        }

        for(String str : input) {
            StringBuilder stringBuilder = new StringBuilder();
            String result = stringBuilder.append(str).reverse().toString();
            System.out.println(result);
        }
    }
}
