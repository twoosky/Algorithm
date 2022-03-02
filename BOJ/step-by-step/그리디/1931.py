# <내 풀이> - 실패(시간 초과)
import sys

def solution(arr):
    arr.sort(key = lambda x: (x[:][0],x[:][2]))
    
    cnt = []
    for i in range(len(arr)):
        res = [arr[i]]
        for j in range(i+1, len(arr)):
            if res[-1][1] <= arr[j][0]:
                res.append(arr[j])
        cnt.append(len(res))
    
    print(max(cnt))


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    arr = []
    for _ in range(N):
        start, end = map(int, sys.stdin.readline().rstrip().split())
        arr.append([start, end, end-start])
    solution(arr)

# <내 풀이> - 실패(시간 초과)
# : DP 적용했으나, 시간 초과
import sys

def solution(arr):
    arr.sort(key = lambda x: (x[:][0],x[:][2]))

    d = [1]*len(arr)
    for i in range(len(arr)):
        for j in range(i):
            if arr[i][0] >= arr[j][1]:
                d[i] = max(d[j]+1, d[i])
    print(max(d))

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    arr = []
    for _ in range(N):
        start, end = map(int, sys.stdin.readline().rstrip().split())
        arr.append([start, end, end-start])
    solution(arr)

# <다른 사람 풀이> *BEST*
# 참고: https://somjang.tistory.com/entry/BaekJoon-1931%EB%B2%88-%ED%9A%8C%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-Python
import sys

def solution(arr):
    # 1. 끝나는 시간을 기준으로 정렬: 빠르게 끝나는 회의일수록, 더 많은 회의가 진행될 수 있으므로
    # 2. 시작 시간을 기준으로 정렬: 시작 시간이 끝나는 시간과 최대한 가까운 순서대로 있어야 더 많은 회의 진행 가능하므로
    # 따라서 끝나는 시간과 시작 시간을 정렬 조건으로 설정
    arr.sort(key = lambda x: (x[1], x[0]))

    answer = [arr[0]]
    for i in range(1, len(arr)):
        if answer[-1][1] <= arr[i][0]:
            answer.append(arr[i])
    
    print(len(answer))


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    arr = []
    for _ in range(N):
        start, end = map(int, sys.stdin.readline().rstrip().split())
        arr.append([start, end])
    solution(arr)