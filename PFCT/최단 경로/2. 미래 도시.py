import sys
INF = int(1e9)

def main():
    N, M = map(int, sys.stdin.readline().rstrip().split())
    graph = [[INF]*(N+1) for _ in range(N+1)]

    for i in range(1, N+1):
        for j in range(1, N+1):
            if i==j:
                graph[i][j] = 0

    for _ in range(M):
        a, b = map(int, sys.stdin.readline().rstrip().split())
        graph[a][b] = 1
        graph[b][a] = 1

    X, K = map(int, sys.stdin.readline().rstrip().split())

    for i in range(1, N+1):
        for j in range(1, N+1):
            for k in range(1, N+1):
                graph[j][k] = min(graph[j][k], graph[j][i]+graph[i][k])
    
    
    cost = graph[1][K] + graph[K][X]
    if cost >= INF:
        print(-1)
    else:
        print(cost)
    
if __name__ == '__main__':
    main()

# <플로이드 워셜 알고리즘>
# 이것이 코딩테스트다 259p

# <입력 예시 1>
# 5 7
# 1 2
# 1 3
# 1 4
# 2 4
# 3 4
# 3 5
# 4 5
# 4 5
# <출력 예시 1>
# 3

# <입력 예시 2>
# 4 2
# 1 3
# 2 4
# 3 4
# <출력 예시 2>
# -1

