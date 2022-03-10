# <내 풀이>
# 백준 질문을 조금 참고한
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
    T = int(sys.stdin.readline().rstrip())
    answer = [[] for _ in range(T)]
    for i in range(T):
        n, m, t = map(int, sys.stdin.readline().rstrip().split())
        s, g, h = map(int, sys.stdin.readline().rstrip().split())
        graph = [[] for _ in range(n+1)]
        for _ in range(m):
            a, b, d = map(int, sys.stdin.readline().rstrip().split())
            graph[a].append((b, d))
            graph[b].append((a, d))
        

        # <틀린 이유>
        # for문 안에 넣어 목적지마다 다익스트라 함수 호출해 최단경로 구함
        # '시간 초과' 발생
        # <수정 사항>
        # 다익스트라 알고리즘은 해당 출발점으로부터 모든 노드의 최단 경로를 구하므로 출발점이 같다면 최단 경로 한번만 구해도 됨
        # 출발점은 s, 거쳐야하는 노드는 g, h로 변함없으므로, 최단 경로를 구한 뒤 목적지 값만 다르게 인덱싱하면 됨.
        # for문 내에서 반복적으로 최단 경로 구할 필요 X
        dist_s = dijkstra(graph, s)
        dist_g = dijkstra(graph, g)
        dist_h = dijkstra(graph, h)
        for _ in range(t):
            t_ = int(sys.stdin.readline().rstrip())
            short_path = dist_s[t_]
            path1 = dist_s[g] + dist_g[h] + dist_h[t_]
            path2 = dist_s[h] + dist_h[g] + dist_g[t_]
            path = min(path1, path2)

            if short_path == path:
                answer[i].append(t_)
        answer[i].sort()

    for ans in answer:
        for a in ans:
            print(a, end=' ')
        print()    

if __name__ == '__main__':
    main()

'''
<아이디어>
1. g, h 교차로 사이에 있는 도로를 지나갔다
  = g, h 노드를 거쳐 목적지에 도달해야 한다.

2. g, h 교차로는 목적지 후보들 중 적어도 1개로 향하는 최단 경로의 일부이다.
  1) 출발점 s에서 목적지 후보들로 가는 최단 경로를 구한다
  2) 출발점 s에서 g, h를 거쳐 목적지 후보들로 가는 최단 경로를 구한다.
  3) 1, 2를 비교해 값이 같으면 g, h 교차로가 최단 경로의 일부이므로 해당 목적지값 출력
 '''