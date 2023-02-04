import sys

N, A = map(int, input().split())
arr = list(map(int, sys.stdin.readline().split()))
# arr = list(map(int, input().split()))

for i in range(N):
    if arr[i] < A:
        print(arr[i], end=' ')