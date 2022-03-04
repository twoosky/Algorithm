# <내 풀이>
# 분할 정복 : 재귀적으로 자신을 호출하면서 그 연산의 단위를 조금씩 줄어가는 방식
import sys

w, b = 0, 0

def solution(x, y, n, graph):
    global w, b
    white, blue = True, True
    for i in range(x, x+n):
        if 1 in graph[i][y:y+n]:
            white = False
        if 0 in graph[i][y:y+n]:
            blue = False
    
    if white: 
        w += 1
    elif blue: 
        b += 1
    else:
        solution(x, y, n//2, graph)
        solution(x, y+n//2, n//2, graph)
        solution(x+n//2, y, n//2, graph)
        solution(x+n//2, y+n//2, n//2, graph)

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    graph = []
    for _ in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

    solution(0, 0, N, graph)
    print(w)
    print(b)

