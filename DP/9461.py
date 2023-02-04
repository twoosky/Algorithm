import sys

p = [1, 1, 1]

def solution(n):
    if len(p) < n:
        for i in range(len(p), n+1):
            p.append(p[i-3] + p[i-2])


if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    answer = []
    for _ in range(T):
        N = int(sys.stdin.readline().rstrip())
        solution(N)
        answer.append(p[N-1])
    for ans in answer:
        print(ans)
        