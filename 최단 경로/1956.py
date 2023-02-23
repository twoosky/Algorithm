# <내 풀이>
# 우선순위큐 알고리즘 사용
# pypy3로 제출해야 시간 초과 발생 안함
import sys
import heapq

INF = int(1e9)

def dijkstra(graph, start):
    q = []
    distance = [INF]*len(graph)
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
    
    return distance

def main():
    V, E = map(int, sys.stdin.readline().rstrip().split())
    graph = [[] for _ in range(V+1)]
    for _ in range(E):
        a, b, c = map(int, sys.stdin.readline().rstrip().split())
        graph[a].append((b, c))
    
    dist = []
    dist.append([])
    # 모든 지점에서 다른 모든 지점까지의 최단 경로 구함
    for i in range(1, V+1):
        dist.append(dijkstra(graph, i))

    answer = []
    for i in range(1, V+1):
        for j in range(1, V+1):
            if dist[i][j] < INF and i != j:
                answer.append(dist[i][j] + dist[j][i])
    
    ans = min(answer)
    if ans >= INF:
        print(-1)
    else:
        print(min(answer))

if __name__ == '__main__':
    main()

# <플로이드 와샬 알고리즘> 사용해서도 풀어볼 것!