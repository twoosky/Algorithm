import sys
from collections import deque

dx = [-1, -2, -2, -1, 1, 2, 2, 1]
dy = [-2, -1, 1, 2, -2, -1, 1, 2]

def bfs(graph, start, target):
    queue = deque([(start[0], start[1])])

    while queue:
        x, y = queue.popleft()

        if (x, y) == target:
            return graph[x][y]

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < len(graph) and ny >= 0 and ny < len(graph[0]):
                if graph[nx][ny] == 0:
                    queue.append((nx, ny))
                    graph[nx][ny] = graph[x][y] + 1


if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    answer = []
    for _ in range(T):
        l = int(sys.stdin.readline().rstrip())
        graph = [[0]*l for _ in range(l)]
        start_x, start_y = map(int, sys.stdin.readline().rstrip().split())
        target_x, target_y = map(int, sys.stdin.readline().rstrip().split())
        answer.append(bfs(graph, (start_x, start_y ), (target_x, target_y)))
    
    for i in answer:
        print(i)
