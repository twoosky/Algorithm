# <내 풀이>
# 백준 질문 참고함
# 참고: https://www.acmicpc.net/board/view/45925
# 참고: https://www.acmicpc.net/board/view/54655

# <틀린 이유>
# 큐에서 뺄 때 방문 처리 -> '메모리 초과' 발생
# 원래는 'x,y = queue.popleft() 밑에 visited[x][y] = 1' 으로 작성함
# 큐에서 뺀 뒤 방문 처리하면 같은 좌표가 중복되어 큐에 들어가므로, 반드시 큐에 넣을 때 방문 표시 해야 함!

# <해결 방법>
# 큐에 삽입할 때 방문 처리하니 오류 해결
# 위 링크 참고

import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(n, x, y, h, graph, visited):
    queue = deque([(x, y)])
    visited[x][y] = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            x_ = x + dx[i]
            y_ = y + dy[i]
            if x_ >= 0 and x_ < n and y_ >= 0 and y_ < n:
                if graph[x_][y_] > h and visited[x_][y_] == 0:
                    visited[x_][y_] = 1
                    queue.append((x_, y_))
    return visited

def main():
    N = int(sys.stdin.readline().rstrip())
    graph = []
    min_height = 101
    max_height = 0
    for _ in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip().split())))
        if min_height > min(graph[-1]):
            min_height = min(graph[-1])
        if max_height < max(graph[-1]):
            max_height = max(graph[-1])

    ans = 0
    for h in range(min_height-1, max_height+2): 
        visited = [[0]*N for _ in range(N)]   
        cnt = 0    
        for i in range(N):
            for j in range(N):
                if graph[i][j] > h and visited[i][j] == 0:
                    bfs(N, i, j, h, graph, visited)
                    cnt += 1
        if ans < cnt:
            ans = cnt
    
    print(ans)

if __name__ == '__main__':
    main()


# <알게된 점>
# **BFS에서는 반드시 큐 삽입 시 방문 체크 해야 함 !!!!!!!!!!!**
# 안그럼 메모리 초과 발생
# 아래 예시 참고
'''
1 - 2 - 3 - 4 - 5

|   |   |    |   |

6 - 7 - 8 - 9 - 0

위의 그림처럼 연결된 그래프가 있고, 1에서 시작 BFS를 사용한다고 하면 큐에는

1

2 6

3 7 7

4 8 8 8

5 9 9 9 9

0 0 0 0 0 0

위와 같이 들어가게 됩니다.

동일한 숫자가 계속 들어가게 되니 메모리에 좋지 않습니다.
'''