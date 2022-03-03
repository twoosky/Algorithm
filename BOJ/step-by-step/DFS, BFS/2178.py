# <다른 사람 풀이> *BEST*
# 참고 : https://velog.io/@norighthere/%EB%B0%B1%EC%A4%80-2178-Python-%EB%AF%B8%EB%A1%9C-%ED%83%90%EC%83%89
import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(n, m, graph, visited):
    queue = deque([(0, 0)])

    while queue:
        x, y = queue.popleft()

        if (x, y) == (n-1, m-1):
            print(visited[-1][-1])
            break
        
        if graph[x][y] == 1:
            graph[x][y] = 0

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx >= 0 and nx < n and ny >= 0 and ny < m:
                    if graph[nx][ny] == 1:
                        visited[nx][ny] = visited[x][y] + 1
                        queue.append((nx, ny))


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().rstrip().split())
    graph = []
    for i in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip())))
    
    visited = [[0]*M for _ in range(N)]
    visited[0][0] = 1
    bfs(N, M, graph, visited)




