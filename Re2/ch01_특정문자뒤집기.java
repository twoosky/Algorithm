package Re2;

import java.util.Scanner;

public class ch01_특정문자뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] n = in.nextLine().toCharArray();

        int lt = 0;
        int rt = n.length - 1;
        while(lt < rt) {
            if (!Character.isAlphabetic(n[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(n[rt])) {
                rt--;
            } else {
                char tmp = n[lt];
                n[lt] = n[rt];
                n[rt] = tmp;
                lt++;
                rt--;
            }
        }

        for(char s : n) {
            System.out.print(s);
        }
    }
}
