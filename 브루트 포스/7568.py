import sys

N = int(sys.stdin.readline().rstrip())

sizes = []

for _ in range(N):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    sizes.append([x, y])

for i in sizes:
    cnt = 1
    for j in sizes:
        if i[0] < j[0] and i[1] < j[1]:
            cnt += 1

    print(cnt, end = " ")