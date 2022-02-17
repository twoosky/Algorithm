import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

cards = list(map(int, sys.stdin.readline().rstrip().split()))

res = list()

for i in range(N):
    for j in range(i + 1, N):
        for k in range(j + 1, N):
            sum = cards[i] + cards[j] + cards[k]
            if sum <= M:
                res.append(sum)

print(max(res))

