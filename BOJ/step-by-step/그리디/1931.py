import sys

def solution(arr):
    arr.sort(key = lambda x: x[:][2])

    print(arr)



if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    arr = []
    for _ in range(N):
        start, end = map(int, sys.stdin.readline().rstrip().split())
        arr.append([start, end, end-start])
    solution(arr)