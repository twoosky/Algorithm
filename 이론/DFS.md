## DFS
* 미로를 탐색할 때, 해당 분기에서 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로(새로운 분기)로 돌아와서 다른 방향으로 다시 탐색을 진행하는 방법과 유사
* 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다.
```java
visited[node] = true;
```

### 1. 그래프 노드 탐색 순서
```java
import java.util.*;

public class DFS {
    private static boolean visited[];
    private static List<List<Integer>> graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        graph = new ArrayList<>();
        graph.add(List.of());
        graph.add(List.of(2, 3, 8));  // 1번 노드
        graph.add(List.of(1, 7));     // 2번 노드
        graph.add(List.of(1, 4, 5));  // 3번 노드
        graph.add(List.of(3, 5));     // 4번 노드
        graph.add(List.of(3, 4));     // 5번 노드
        graph.add(List.of(7));        // 6번 노드
        graph.add(List.of(2, 6, 8));  // 7번 노드
        graph.add(List.of(1, 7));     // 8번 노드

        visited = new boolean[9];
        dfs(1);
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int n : graph.get(node)) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}

```
```
1 2 7 6 8 3 4 5 
```

### 2. DFS로 모든 경우의 수 완전탐색하기
* 최대값 구하기, 최소값 구하기, 원하는 값 구하기 등에 사용
* *값이 나열되어 있고, 이 중 어떤 것을 선택해야 최대값이 되는가* 이런 문제에 활용
* `예시` : 제한 시간 내 풀 수 있는 최대 점수 구하기

<img src="https://user-images.githubusercontent.com/50009240/220447870-9c3c5a9e-479d-41e3-a3a6-9c516a13af67.png" weight="650" height="500">

```java
import java.util.*;

class Question {
    int score;
    int time;

    public Question(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class DFS_완전탐색 {
    private static int n;
    private static int m;
    private static List<Question> arr;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();  // 문제 개수
        m = in.nextInt();  // 제한 시간
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = in.nextInt();  // 점수
            int time = in.nextInt();  // 걸리는 시간
            arr.add(new Question(score, time));
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int idx, int time, int sum) {
        if (time > m) {
            return;
        }

        if (idx == n) {
            result = Math.max(result, sum);
            return;
        }

        Question question = arr.get(idx);

        // 해당 문제를 푸는 경우
        dfs(idx + 1, time + question.time, sum + question.score);
        // 해당 문제를 풀지 않는 경우
        dfs(idx + 1, time, sum);
    }
}
```

```
입력 예제
5 20
10 5
25 12
15 8
6 3
7 4

출력 예제
41
```

