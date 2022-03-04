# <다른 사람 코드>
# 참고: https://claude-u.tistory.com/443
# 알고리즘을 생각한 뒤 구현하자
import sys

def binary_search(k, n, length):
    start = 1
    end = max(length)
    answer = 0
    while start <= end:
        mid = (start+end)//2
        cnt = 0
        for i in range(k):
            cnt += length[i]//mid
        if cnt < n:
            end = mid - 1
        elif cnt >= n :
            answer = mid
            start = mid + 1
    
    print(answer)


def main():
    K, N = map(int, sys.stdin.readline().rstrip().split())
    length = []
    for _ in range(K):
        length.append(int(sys.stdin.readline().rstrip()))
    binary_search(K, N, length)

if __name__ == '__main__':
    main()