import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(n, m, graph):
    visited = [[0]*m for _ in range(n)]
    visited[0][0] = 1
    queue = deque([(0, 0)])
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            x_ = x + dx[i]
            y_ = y + dy[i]
            if x_ >= 0 and x_ < n and y_ >= 0 and y_ < m:
                if graph[x_][y_] == 1:
                    if visited[x_][y_] == 0:
                        visited[x_][y_] = visited[x][y] + 1
                        queue.append((x_, y_))
    
    print(visited[-1][-1])


def main():
    N, M = map(int, sys.stdin.readline().rstrip().split())
    graph = []
    for _ in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip())))
    
    bfs(N, M, graph)

if __name__ == '__main__':
    main()