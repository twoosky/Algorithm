import sys

def solution(a, b):
    a.sort()
    for i in range(len(b)):
        start = 0
        end = len(a)-1
        mid = len(a)//2
        while True:
            if start > end:
                print("0")
                break
            if a[mid] == b[i]:
                print("1")
                break
            elif a[mid] < b[i]:
                start = mid+1
            elif a[mid] > b[i]:
                end = mid-1
            mid = (end+start)//2


def main():
    N = int(sys.stdin.readline().rstrip())
    A = list(map(int, sys.stdin.readline().rstrip().split()))
    M = int(sys.stdin.readline().rstrip())
    B = list(map(int, sys.stdin.readline().rstrip().split()))
    solution(A, B)

if __name__ == '__main__':
    main()

# <이분 탐색 알고리즘>
# 개념 참고: 이것이 취업을 위한 코딩테스트다 188p