package 인프런.ch2;

import java.util.*;

public class 큰_수_출력하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        List<Integer> nums = new ArrayList<>();

        for(int i = 0; i < input; i++) {
            nums.add(in.nextInt());
        }

        System.out.print(nums.get(0) + " ");
        for(int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) < nums.get(i)) {
                System.out.print(nums.get(i) + " ");
            }
        }
    }
}
