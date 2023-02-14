package 인프런.ch6;

import java.util.*;

public class 좌표정렬_삽입정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j][0] < arr[j-1][0]) {
                    swap(arr, j);
                } else if (arr[j][0] == arr[j-1][0] && arr[j][1] < arr[j-1][1]) {
                    swap(arr, j);
                } else {
                    break;
                }
            }
        }

        for(int[] num : arr) {
            System.out.println(num[0] + " " + num[1]);
        }
    }

    private static void swap(int[][] arr, int j) {
        int x = arr[j][0];
        int y = arr[j][1];
        arr[j][0] = arr[j-1][0];
        arr[j][1] = arr[j-1][1];
        arr[j-1][0] = x;
        arr[j-1][1] = y;
    }
}
