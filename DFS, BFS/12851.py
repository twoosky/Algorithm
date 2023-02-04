# <내 풀이>
# 시간 초과 근데 풀이는 맞는듯
import sys
from collections import deque

def bfs(n, k):
    queue = deque([(n, [n])])
    d = [0]*100001
    count = [100000]
    while queue:
        x, nodes = queue.popleft()
        if x == k:
            count.append(len(nodes)-1)
            continue

        if len(nodes) <= min(count):
            dx = [x-1, x+1, x*2]
            for i in range(3):
                x_ = dx[i]
                tmp = nodes.copy()
                if x_ >= 0 and x_ <= 100000 and x_ not in nodes:
                    tmp.append(x_)
                    queue.append((x_, tmp))
    
    return count

def main():
    N, K = map(int, sys.stdin.readline().rstrip().split())

    if N == K:
        print(0)
        print(1)
        return

    # dn = [N-1, N+1, N*2]
    # answer = []
    answer = bfs(N, K)
    
    print(min(answer))
    print(answer.count(min(answer)))

    

if __name__ == '__main__':
    main()

# 다른 사람 코드  *BEST*
# 참고: https://velog.io/@dhelee/%EB%B0%B1%EC%A4%80-12851%EB%B2%88-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%884-Python-%EB%84%88%EB%B9%84-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89BFS
import sys
from collections import deque

def bfs(n, k):
    # visited = [도달하는데 걸린 시간, 경우의 수]
    visited = [[-1, 0] for _ in range(100001)]
    visited[n][0] = 0
    visited[n][1] = 1
    queue = deque([n])
    while queue:
        x = queue.popleft()

        dx = [x-1, x+1, x*2]
        for i in dx:
            if i >= 0 and i <= 100000:
                if visited[i][0] == -1:
                    visited[i][0] = visited[x][0]+1
                    visited[i][1] = visited[x][1]
                    queue.append(i)
                
                elif visited[i][0] == (visited[x][0]+1):
                    visited[i][1] += visited[x][1]
    
    print(visited[k][0])
    print(visited[k][1])

def main():
    N, K = map(int, sys.stdin.readline().rstrip().split())
    bfs(N, K)

if __name__ == '__main__':
    main()