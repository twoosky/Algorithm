import sys

answer = [1, 2]

def solution(n):
    if len(answer) < n:
        for i in range(len(answer), n):
            answer.append((answer[i-2] + answer[i-1])%15746)

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    solution(N)
    print(answer[N-1])