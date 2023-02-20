package 인프런.ch9;

import java.util.*;

class Body implements Comparable<Body> {
    int height;
    int weight;
    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    // 키를 기준으로 내림차순 정렬
    @Override
    public int compareTo(Body object) {
        return object.height - this.height;
    }
}

public class 씨름_선수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        Body[] arr2 = new Body[n];
        for(int i = 0; i < n; i++) {
            int height = in.nextInt();
            int weight = in.nextInt();
            arr[i][0] = height;
            arr[i][1] = weight;
            arr2[i] = new Body(height, weight);
        }

        System.out.println(solution(arr2));
    }

    // 인프런 풀이: 키를 기준으로 정렬 후 몸무게만 비교
    // - Comparable<T>의 compareTo 메서드 오버라이딩
    private static int solution(Body[] arr) {
        Arrays.sort(arr);

        int result = 1;
        int weight_max = arr[0].weight;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i].weight > weight_max) {
                weight_max = arr[i].weight;
                result++;
            }
        }
        return result;
    }

    // 내 풀이: 이중 for문으로 전부 돌며 키, 몸무게 비교
    private static int solution1(int n, int[][] arr) {
        int result = 0;
        for(int i = 0; i < n; i++) {
            int height = arr[i][0];
            int weight = arr[i][1];
            int j;
            for(j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[j][0] > height && arr[j][1] > weight) {
                    break;
                }
            }
            if (j == n) {
                result++;
            }
        }
        return result;
    }
}
