import sys
from collections import deque

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')

    for i in graph[v]:
        if visited[i] == False:
            dfs(graph, i, visited)

def bfs(graph, v, visited):
    queue = deque(v)
    visited[v] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')

        for i in graph[v]:
            if visited[i] == False:
                queue.append(i)
                visited[i] = True

if __name__ == '__main__':
    N, M, V = map(int, sys.stdin.readline().rstrip().split())
    graph = [[] for _ in range(N+1)]
    for _ in range(M):
        node1, node2 = map(int, sys.stdin.readline().rstrip().split())
        graph[node1].append(node2)
        graph[node1].sort()
        if node1 not in graph[node2]:
            graph[node2].append(node1)
            graph[node2].sort()

    visited = [False]*(N+1)
    dfs(graph, V, visited)
    bfs(graph, V, visited)
