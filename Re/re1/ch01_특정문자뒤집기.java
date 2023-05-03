package Re.re1;

import java.util.*;

public class ch01_특정문자뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.next().split("");
        String[] result = new String[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i].charAt(0))) {
                result[arr.length - 1 - i] = arr[i];
            } else {
                result[i] = arr[i];
            }
        }

        for(String str : result) {
            System.out.print(str);
        }
    }
}
