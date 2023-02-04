import sys

N = int(sys.stdin.readline().rstrip())

res = [0] * 10000

for _ in range(N):
    num = int(sys.stdin.readline().rstrip())
    res[num - 1] += 1

for i in range(10000):
    while res[i] > 0:
        print(i + 1)
        res[i] -= 1