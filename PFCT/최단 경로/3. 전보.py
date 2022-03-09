import sys
INF = int(1e9)
import sys
import heapq
    

def main():
    N, M, C = map(int, sys.stdin.readline().rstrip().split())
    graph = [[]*(N+1) for _ in range(N+1)]
    for _ in range(M):
        X, Y, Z = map(int, sys.stdin.readline().rstrip().split())
        graph[X].append((Y, Z))

    distance = [INF]*(N+1)
    q = []
    heapq.heappush(q, (0, C))
    distance[C] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = distance[now] + i[1]
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    cnt = 0
    max_distance = 0
    for d in distance:
        if d != INF:
            cnt += 1
            max_distance = max(max_distance, d)

    print(cnt-1, max_distance)


if __name__ == '__main__':
    main()

# <다익스트라 알고리즘>
# 이것이 코딩테스트다 262p

# <입력 예시>
# 3 2 1
# 1 2 4
# 1 3 2
# <출력 예시>
# 2 4