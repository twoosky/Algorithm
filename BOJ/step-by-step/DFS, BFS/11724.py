# <내 풀이>
# 첫번째 시도에 틀림. 수정 후 성공

# <틀린 이유>
# a정점에만 b정점 삽입해 틀림
# 같은 간선은 한 번만 주어진다.
# -> 양방향이다. 두 정점에 모두 서로 다른 정점 삽입 해야됨

# <해결 방법>
# a정점에 b정점 삽입, b정점에도 a정점 삽입

import sys
from collections import deque

def bfs(v, graph, visited):
    queue = deque([v])
    visited[v] = 1
    while queue:
        v = queue.popleft()

        for i in graph[v]:
            if visited[i] == 0:
                visited[i] = 1
                queue.append(i)
    return visited

def main():
    N, M = map(int, sys.stdin.readline().rstrip().split())
    graph = [[] for _ in range(N+1)]
    for _ in range(M):
        a, b = map(int, sys.stdin.readline().rstrip().split())
        graph[a].append(b)
        graph[b].append(a)
    
    visited = [0]*(N+1)
    cnt = 0
    for v in range(1, N+1):
        if visited[v] == 0:
            visited = bfs(v, graph, visited)
            cnt += 1
    print(cnt)


if __name__ == '__main__':
    main()