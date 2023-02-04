import sys
N = int(sys.stdin.readline().rstrip())
score = list(map(int, sys.stdin.readline().rstrip().split()))

max = max(score)
sum = 0

for i in range(N):
    sum += score[i]/max*100

print(sum/N)
