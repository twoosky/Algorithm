# <내 풀이> - DFS
import sys
sys.setrecursionlimit(10**6)

def dfs(graph, x, y):
    if x < 0 or y < 0 or x >= len(graph) or y >= len(graph[0]):
        return False

    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(graph, x-1, y)
        dfs(graph, x+1, y)
        dfs(graph, x, y-1)
        dfs(graph, x, y+1)
        return True

    return False

if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    answer = []
    for _ in range(T):
        M, N, K = map(int, sys.stdin.readline().rstrip().split())
        graph = [[0]*M for _ in range(N)]
        for _ in range(K):
            y, x = map(int, sys.stdin.readline().rstrip().split())
            graph[x][y] = 1
        cnt = 0
        for i in range(N):
            for j in range(M):
                if dfs(graph, i, j) == True:
                    cnt += 1
        answer.append(cnt)
    
    for i in answer:
        print(i)

# <알게된 점>
# sys.setrecursionlimit(10**6)
# 재귀 사용시 위 코드 상단에 추가해줘야됨
# : recursion 깊이가 너무 적게 지정이 된 경우, 재귀를 하다가 런타임 에러가 발생할 수 있으므로
# 이 코드 추가 안해서 런타임 에러 뜸 ㅋ
# 그냥 재귀 사용하지 않는게 나을 수도 ^^..
# 스택을 사용한 dfs 구현해보자


# <내 풀이> - BFS
import sys
from collections import deque

d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def bfs(graph, i, j):
    queue = deque([(i, j)])

    while queue:
        x, y = queue.popleft()

        if graph[x][y] == 1:
            graph[x][y] = 0

            for i in d:
                a = x + i[0]
                b = y + i[1]
                if a >= 0 and a < len(graph) and b >= 0 and b < len(graph[0]):
                    queue.append((a, b))                

if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    answer = []
    for _ in range(T):
        M, N, K = map(int, sys.stdin.readline().rstrip().split())
        graph = [[0]*M for _ in range(N)]
        for _ in range(K):
            y, x = map(int, sys.stdin.readline().rstrip().split())
            graph[x][y] = 1
        cnt = 0
        for i in range(N):
            for j in range(M):
                if graph[i][j] == 1:
                    bfs(graph, i, j)
                    cnt += 1
        answer.append(cnt)
    
    for i in answer:
        print(i)






















