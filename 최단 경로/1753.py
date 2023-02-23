import sys
import heapq

INF = int(1e9)

def main():
    V, E = map(int, sys.stdin.readline().rstrip().split())
    K = int(sys.stdin.readline().rstrip())
    graph = [[] for _ in range(V+1)]
    distance = [INF]*(V+1)
    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().rstrip().split())
        graph[u].append((v, w))
    
    q = []
    distance[K] = 0
    heapq.heappush(q, (0, K))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        
        for d in graph[now]:
            cost = dist + d[1]
            if cost < distance[d[0]]:
                distance[d[0]] = cost
                heapq.heappush(q, (cost, d[0]))
    
    for i in range(1, V+1):
        if distance[i] == INF:
            print("INF")
        else:
            print(distance[i])


if __name__ == '__main__':
    main()

# <우선순위큐 알고리즘>
# - 한 지점에서 다른 특정 지점까지의 최단 경로 구하는 경우 사용
# - 하나의 노드에서 나머지 모든 노드까지의 최단 거리 찾음
# <폴로이드 워셜 알고리즘>
# - 모든 지점에서 다른 모든 지점까지의 최단 경로를 구해야 하는 경우 사용
# - 모든 노드의 최단 거리를 구함 