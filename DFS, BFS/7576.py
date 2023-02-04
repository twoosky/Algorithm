# <내 풀이>
# 3번 틀리고 맞음

# <틀린 이유 1>
# 익은 토마토가 1개도 없는 경우 고려 안함
# <해결 방법 1>
# graph에 1이 없는 경우, 즉 tomato 리스트가 비어있는 경우 -1 출력

# <틀린 이유 2>
# graph에서 1값 찾을 때 같은 줄에 1이 여러개 있을 수 있음을 고려 안함
# : if 1 in graph[i]: tomato.append(graph[i].index(1)) 
# 이렇게 코드 작성했었음. 그래서 같은 줄에 1이 여러개면 맨 앞의 1 인덱스만 삽입됨.

# <해결 방법 2>
# 이중 for문 돌려 graph의 각 요소마다 검사해 1이면 tomato리스트에 삽입

import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(m, n, tomato, graph):
    queue = deque()
    for t in tomato:
        queue.append((t[0], t[1]))
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            x_ = x + dx[i]
            y_ = y + dy[i]
            if x_ >= 0 and x_ < n and y_ >= 0 and y_ < m:
                if graph[x_][y_] == 0:
                    graph[x_][y_] = graph[x][y] + 1
                    queue.append((x_, y_))

    return graph[x][y]-1


def main():
    M, N = map(int, sys.stdin.readline().rstrip().split())
    graph = []
    for i in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

    tomato = []
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                tomato.append((i, j))
    if len(tomato) == 0:
        print(-1)
        return
    answer = bfs(M, N, tomato, graph)
    
    for i in range(N):
        if 0 in graph[i]:
            print(-1)
            return
    print(answer)


if __name__ == '__main__':
    main()