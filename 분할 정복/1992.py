import sys

def solution(x, y, n, graph):
    zero, one = True, True
    for i in range(x, x+n):
        if 1 in graph[i][y:y+n]:
            zero = False
        if 0 in graph[i][y:y+n]:
            one = False
    
    if zero:
        print(0, end='')
        return
    if one:
        print(1, end='')
        return
    else:
        print("(", end='')
        solution(x, y, n//2, graph)
        solution(x, y+n//2, n//2, graph)
        solution(x+n//2, y, n//2, graph)
        solution(x+n//2, y+n//2, n//2, graph)
        print(")", end='')

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    graph = []
    for _ in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip())))
    solution(0, 0, N, graph)