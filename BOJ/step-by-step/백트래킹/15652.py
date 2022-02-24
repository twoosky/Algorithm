import sys
from itertools import combinations_with_replacement

def solution(N, M):
    array = []
    for i in range(1, N+1):
        array.append(i)
    answer = list(combinations_with_replacement(array, M))
    answer = sorted(answer)
    for ans in answer:
        for i in range(M):
            print(ans[i], end=' ')
        print()

if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().rstrip().split())
    solution(N, M)