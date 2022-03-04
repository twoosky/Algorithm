import sys

def binary_search(n, m, tree):
    start = 0
    end = max(tree)
    answer = 0
    while start <= end:
        cnt = 0
        mid = (start+end)//2
        for t in tree:
            if t > mid:
                cnt += t-mid
        if cnt < m:
            end = mid - 1
        elif cnt >= m:
            answer = mid
            start = mid + 1
    
    print(answer)


def main():
    N, M = map(int, sys.stdin.readline().rstrip().split())
    tree = list(map(int, sys.stdin.readline().rstrip().split()))
    binary_search(N, M, tree)

if __name__ == '__main__':
    main()