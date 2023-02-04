import sys
from collections import deque

def bfs(graph, v, visited):
    # deque 선언할 때 시작 노드 [] 리스트로 묶어 deque 초기화
    queue = deque([v])
    visited[v] = True

    cnt = 0
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visited[i] == False:
                queue.append(i)
                visited[i] = True
                cnt += 1
    
    print(cnt)


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    M = int(sys.stdin.readline().rstrip())
    
    # N+1은 노드번호를 1부터 설정해 접근하기 위해 해줌
    # 참고 : 이것이 취업을 위한 코딩테스트다 147p
    graph = [[] for _ in range(N+1)]
    for _ in range(M):
        node1, node2 = map(int, sys.stdin.readline().rstrip().split())
        graph[node1].append(node2)
        graph[node1].sort()
        if node1 not in graph[node2]:
            graph[node2].append(node1)
            graph[node2].sort()
    
    visited = [False]*(N+1)
    bfs(graph, 1, visited)
