import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(n, m, x, y, type, graph):
    queue = deque([(x, y)])
    count = 1
    graph[x][y] = 'E'
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            x_ = x + dx[i]
            y_ = y + dy[i]
            if x_ >= 0 and x_ < m and y_ >= 0 and y_ < n:
                if graph[x_][y_] == type:
                    graph[x_][y_] = 'E'
                    count += 1
                    queue.append((x_, y_))
    
    return count**2

def main():
    N, M = map(int, sys.stdin.readline().rstrip().split())
    graph = []
    for _ in range(M):
        graph.append(list(sys.stdin.readline().rstrip())[:N])
    w = 0
    b = 0
    for i in range(M):
        for j in range(N):
            if graph[i][j] == 'W':
                w += bfs(N, M, i, j, 'W', graph)
            elif graph[i][j] == 'B':
                b += bfs(N, M, i, j, 'B', graph)

    print(w, b)

if __name__ == '__main__':
    main()