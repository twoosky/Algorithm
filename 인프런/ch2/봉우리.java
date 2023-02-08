package 인프런.ch2;

import java.util.*;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] input = new int[size][size];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                input[i][j] = in.nextInt();
            }
        }

        int count = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                boolean flag = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < size && ny >= 0 && ny < size && input[i][j] <= input[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
