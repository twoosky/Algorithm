import sys

N = int(sys.stdin.readline().rstrip())

res = []

num = 0

while len(res) != N:
    if "666" in str(num):
        res.append(num)
    num += 1

res.sort()
print(res[N-1])
