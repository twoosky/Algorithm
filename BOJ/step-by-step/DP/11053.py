# 10 20 5 10 15 30
# 10 -> 20 -> 30
# 5 -> 10 -> 15 -> 30

# 10 10 5 10 50 15
# 5 -> 10 -> 20 -> 50

# 30 10 15 5 30 40
# 10 -> 15 -> 30 -> 40
# 30 -> 40
# 5 -> 30 -> 40

# <다른 사람 풀이>
# 참고 : https://zidarn87.tistory.com/285
import sys

def solution(N, arr):
    # d 리스트: 자신까지 오는데 가장 긴 수열의 길이 저장
    d = [1]*N
    
    for i in range(N):
        for j in range(i):
            if arr[i] > arr[j]:
                d[i] = max(d[i], d[j] + 1)
    
    print(max(d))

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    arr = list(map(int,sys.stdin.readline().rstrip().split()))
    solution(N, arr)

