import sys

def solution(n):
    d = []
    d.append(1)
    d.append(2)

    for i in range(2, n):
        d.append((d[i-2] + d[i-1])%10007)
    
    print(d[n-1])

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    solution(N)