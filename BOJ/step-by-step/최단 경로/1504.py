# <내 풀이>
# 백준의 질문을 조금 참고한
import sys
import heapq

INF = int(1e9)

def dijkstra(n, graph, start, end):
    global cnt
    q = []
    distance = [INF]*(n+1)
    distance[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    
    return distance[end]

def main():
    N, E = map(int, sys.stdin.readline().rstrip().split())
    graph = [[] for _ in range(N+1)]
    for _ in range(E):
        a, b, c = map(int, sys.stdin.readline().rstrip().split())
        graph[a].append((b, c))
        graph[b].append((a, c))

    v1, v2 = map(int, sys.stdin.readline().rstrip().split())

    # 처음엔 path1만 고려해서 틀림. v1,v2 거치는 순서에 따라 최단 경로 다를 수도 있음!
    # 1 - v1 - v2 - N
    path1 = (dijkstra(N, graph, 1, v1) + dijkstra(N, graph, v1, v2) + dijkstra(N, graph, v2, N))
    # 1 - v2 - v1 - N
    path2 = (dijkstra(N, graph, 1, v2) + dijkstra(N, graph, v2, v1) + dijkstra(N, graph, v1, N))

    path = min(path1, path2)
    if path >= INF:
        print(-1)
    else:
        print(path)

if __name__ == '__main__':
    main()