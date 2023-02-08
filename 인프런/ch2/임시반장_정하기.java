package 인프런.ch2;

import java.util.*;

public class 임시반장_정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] input = new int[size][5];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < 5; j++) {
                input[i][j] = in.nextInt();
            }
        }

        int max = 0;
        int result = 0;
        for(int i = 0; i < size; i++) {  // 학생
            Set<Integer> student = new HashSet<>();
            for(int j = 0; j < 5; j++) {  // 학년
                for(int k = 0; k < size; k++) {
                    if (i != k && input[i][j] == input[k][j]) {
                        student.add(k);
                    }
                }
            }
            if (max < student.size()) {
                max = student.size();
                result = i + 1;
            }
        }
        if (result == 0) {
            result = 1;
        }
        System.out.print(result);
    }
}
