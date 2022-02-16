import sys

A = int(sys.stdin.readline().rstrip())
B = int(sys.stdin.readline().rstrip())
C = int(sys.stdin.readline().rstrip())

res = A * B * C
cnt = [0] * 10

while(res > 0):
    temp = int(res % 10)
    res = res // 10
    cnt[temp] += 1

for i in range(10):
    print(cnt[i])
