# <다른 사람 풀이> *BEST*
# 참고 : https://jainn.tistory.com/83
# - 이걸 어떻게 생각해냄?

import sys

def solution(stairs):
    d = []
    if len(stairs) == 1:
        print(stairs[0])
        return
    elif len(stairs) == 2:
        print(stairs[0] + stairs[1])
        return
    d.append(stairs[0])
    d.append(stairs[0] + stairs[1])
    d.append(max(stairs[0] + stairs[2], stairs[1] + stairs[2]))

    for i in range(3, len(stairs)):
        d.append(max(d[i-2]+stairs[i], d[i-3]+stairs[i-1]+stairs[i]))
    print(d[-1])

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    stairs = []
    for _ in range(N):
        stairs.append(int(sys.stdin.readline().rstrip()))
    solution(stairs)

# <알게된 점>
# dp 풀이 방식
# : 대부분 몇 개의 케이스를 하드코딩해주고, 나머지 경우들을 점화식을 통해 처리!