import sys

N = int(sys.stdin.readline().rstrip())

res = []

for _ in range(N):
    res.append(int(sys.stdin.readline().rstrip()))

res.sort()

for i in range(N):
    print(res[i])

# for num in res:
#     print(num)