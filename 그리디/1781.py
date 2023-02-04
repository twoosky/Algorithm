# <내 풀이>
# 시간초과 나네 무조건 heapq을 서야되나봄
import sys

def solution(n, arr):
    arr.sort()
    arr.sort(reverse=True, key=lambda x: x[1])
    nums = [arr[0][0]]
    cnt = arr[0][1]
    for i in range(n):
        for j in range(i+1, n):
            if arr[j][0] not in nums:
                cnt += arr[j][1]
                nums.append(arr[j][0])
    print(cnt)

def main():
    N = int(sys.stdin.readline().rstrip())
    arr = []
    for _ in range(N):
        i, j = map(int, sys.stdin.readline().rstrip().split())
        arr.append([i,j])
    solution(N, arr)

if __name__ == '__main__':
    main()