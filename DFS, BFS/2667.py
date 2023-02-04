# <내 풀이> - DFS
import sys

cnt = 0

def dfs(graph, x, y, visited):
    global cnt
    if x < 0 or y < 0 or y == len(graph) or x == len(graph):
        return False
    if visited[x][y] == True:
        return False
    if graph[x][y] == 1:
        visited[x][y] = True
        cnt += 1
        dfs(graph, x-1, y, visited)
        dfs(graph, x+1, y, visited)
        dfs(graph, x, y+1, visited)
        dfs(graph, x, y-1, visited)
        return True
    return False

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    graph = []
    for i in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip())))
    
    visited = [[False]*N for _ in range(N)]
    res = []
    for i in range(N):
        for j in range(N):
            if dfs(graph, i, j, visited):
                res.append(cnt)
                cnt = 0
    res.sort()
    print(len(res))
    for i in res:
        print(i)

# 참고: 이것이 취업을 위한 코딩테스트다 149p

# <궁금한 점>
# DFS로 해결할 수 있다는데 BFS로는 안되나?
# 알고리즘 선택 기준을 모르겠음

# <32번 라인>
# if dfs(graph, i, j, visited):
#     res.append(cnt)
#     cnt = 0
# -> 여기서 dfs()의 리턴값이 True인 경우 연결된 모든 노드를 탐색한 것임
# 010
# 110
# 001
# 위 그래프 예시로 들어 코드 이해

# <내 풀이> - BFS
import sys
from collections import deque

d = [[1, 0], [-1, 0], [0, 1], [0, -1]]

def bfs(graph, x, y):
    queue = deque([[x, y]])
    res = 0
    while queue:
        x, y = queue.popleft()
        if graph[x][y] == 1:
            res += 1
            graph[x][y] = 0
            for i in d:
                a = x + i[0]
                b = y + i[1]
                if a > -1 and b > -1 and a < len(graph) and b < len(graph):
                    queue.append([a, b])
    return res

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    graph = []
    for _ in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip())))

    answer = []
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 1:
                answer.append(bfs(graph, i, j))
    
    answer.sort()
    print(len(answer))
    for i in answer:
        print(i)

























