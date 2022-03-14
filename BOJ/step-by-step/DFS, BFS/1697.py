import sys
from collections import deque

dx = [-1, 1]

def dfs(n, k):
    cnt = []
    for i in range(3):
        visited = [0]*100001
        if i == 2:
            n_ = n*2
        else:
            n_ = n + dx[i]
        stack = deque([n_])
        
        while stack:
            x = stack.pop()
            print(x)
            if x == k:
                cnt.append(visited[x]+1)
                break
            for i in range(3):
                if i == 2:
                    x_ = x*2
                else:
                    x_ = x + dx[i]
                if x_ >= 0 and x_ <= 100000:
                    if visited[x_] == 0:
                        visited[x_] = visited[x] + 1
                        stack.append(x_)
    
    print(cnt)
    print(min(cnt))




def main():
    N, K = map(int, sys.stdin.readline().rstrip().split())
    dfs(N, K)

if __name__ == '__main__':
    main()