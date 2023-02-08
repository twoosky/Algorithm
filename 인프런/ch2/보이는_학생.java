package 인프런.ch2;

import java.util.*;

public class 보이는_학생 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        List<Integer> nums = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            nums.add(in.nextInt());
        }

        int max = nums.get(0);
        int count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (max < nums.get(i)) {
                count++;
                max = nums.get(i);
            }
        }

        System.out.print(count);
    }
}
