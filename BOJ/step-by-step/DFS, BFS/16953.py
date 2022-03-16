# <내 풀이>
import sys
from collections import deque

def bfs(a, b):
    queue = deque([(a, 1)])
    while queue:
        x, cnt = queue.popleft()

        if x == b:
            print(cnt)
            return
        
        dx = [x*2, int(str(x)+'1')]
        for i in range(2):
            x_ = dx[i]
            if x_ <= b:
                queue.append((x_, cnt+1))
    
    print(-1)
    return


def main():
    A, B = map(int, sys.stdin.readline().rstrip().split())
    bfs(A, B)

if __name__ == '__main__':
    main()

# <알게된 점>
'''
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다. 
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
'''
# 이런 식으로 a에서 b가 되는 연산의 최솟값 구하는 문제는
# bfs로 푼다 !!!!!!!!!!1

# <아이디어>
# 1. queue에 (연산한 값, 연산횟수 or 연산기호(dslr)) 튜플 형식으로 삽입
# 2. 그리고 연산횟수 or 연산기호를 연산할 때마다 누적해줌

# 9019번 문제 DSLR도 이와 같은 방식