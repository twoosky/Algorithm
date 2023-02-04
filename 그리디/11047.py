import sys

def solution(n, k, coin):
    coin.sort(reverse = True)
    cnt = 0

    for c in coin:
        cnt += k//c
        k = k%c
    print(cnt)



if __name__ == '__main__':
    N, K = map(int, sys.stdin.readline().rstrip().split())
    coin = []
    for _ in range(N):
        coin.append(int(sys.stdin.readline().rstrip()))
    solution(N, K, coin)