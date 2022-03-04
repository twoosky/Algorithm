import sys

cnt_0, cnt_1, cnt_1_ = 0, 0, 0

def solution(x, y, n, graph):
    global cnt_0, cnt_1, cnt_1_
    check_0, check_1, check_1_ = True, True, True
    for i in range(x, x+n):
        if -1 in graph[i][y:y+n]:
            check_0, check_1 = False, False
        if 0 in graph[i][y:y+n]:
            check_1, check_1_ = False, False
        if 1 in graph[i][y:y+n]:
            check_0, check_1_ = False, False
        
    if check_1_: 
        cnt_1_ += 1
        return
    elif check_0:
        cnt_0 += 1
        return
    elif check_1:
        cnt_1 += 1
        return
    else:
        solution(x, y, n//3, graph)
        solution(x, y+n//3, n//3, graph)
        solution(x, y+(n//3*2), n//3, graph)
        solution(x+n//3, y, n//3, graph)
        solution(x+n//3, y+n//3, n//3, graph)
        solution(x+n//3, y+(n//3*2), n//3, graph)
        solution(x+(n//3*2), y, n//3, graph)
        solution(x+(n//3*2), y+n//3, n//3, graph)
        solution(x+(n//3*2), y+(n//3*2), n//3, graph)
        

def main():
    N = int(sys.stdin.readline().rstrip())
    graph = []
    for _ in range(N):
        graph.append(list(map(int, sys.stdin.readline().rstrip().split())))
    solution(0, 0, N, graph)
    global cnt_0, cnt_1, cnt_1_
    print(cnt_1_)
    print(cnt_0)
    print(cnt_1)

if __name__ == '__main__':
    main()