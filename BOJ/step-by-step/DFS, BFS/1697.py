# <내 풀이>
# 돌아가게만 만들자.. 라는 생각으로 짜서 코드가 더러움
# 백준의 질문을 조금 참고해 성공한 코드
# 참고: https://www.acmicpc.net/board/view/82583
# dfs 써야되는줄 알았는데 bfs 쓰는 문제 였음.

# <틀린 이유>
# n과 k가 같은 경우 0이 출력되어야 하는데, 2가 출력 됨
# 왜냐면 n을 미리 n-1, n+1, n*2으로 계산해 큐에 넣기 때문에
# n+1 된 뒤 x-1 되어 2가 출력되는 것임

# <해결 방법>
# bfs를 실행하기 전 if n==k: print(0) 코드 추가하니 해결

import sys
from collections import deque

dx = [0, 1, -1]

def bfs(n, k):
    cnt = []
    if n == k:
        print(0)
        return
    for i in range(3):
        visited = [False]*100001
        d = [0]*100001
        if i == 0:
            n_ = n*2
        else:
            n_ = n + dx[i]
        if n_ >= 0 and n_ <= 100000:
            d[n_] = 1
            visited[n_] = True
            queue = deque([n_])
        else: continue
        while queue:
            x = queue.popleft()

            if x == k:
                cnt.append(d[x])
                break
            
            for i in range(3):
                if i == 0:
                    x_ = x*2
                else:
                    x_ = x + dx[i]

                if x_ >= 0 and x_ <= 100000:
                    if visited[x_] == False:
                        d[x_] = d[x] + 1
                        visited[x_] = True
                        queue.append(x_)
    
    print(min(cnt))

def main():
    N, K = map(int, sys.stdin.readline().rstrip().split())
    bfs(N, K)

if __name__ == '__main__':
    main()



# <다른 사람 풀이>  *BEST*
# 참고: https://www.acmicpc.net/board/view/82583
import sys
from collections import deque

def bfs(n, k):
    d = [0]*100001

    queue = deque([n])
    while queue:
        x = queue.popleft()
        if x == k:
            break

        dx = [x-1, x+1, x*2]
        for x_ in dx:
            if x_ >= 0 and x_ <= 100000 and not d[x_]:
                d[x_] = d[x] + 1
                queue.append(x_)
    
    print(d[k])

def main():
    N, K = map(int, sys.stdin.readline().rstrip().split())
    bfs(N, K)

if __name__ == '__main__':
    main()