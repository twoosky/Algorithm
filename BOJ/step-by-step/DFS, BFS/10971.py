# <내 풀이>
# 완벽히 틀림
# 다른 사람 풀이 봐도 뭔소린지 모르겠음 ㅋ..
import sys
from collections import deque

def dfs(n, start, next, graph):
    visited = [[False]*n for _ in range(n)]
    d = [0]*n
    d[next] = graph[start][next]
    stack = deque([next])
    nodes = set()
    nodes.add(start)
    while stack:
        now = stack.pop()
        nodes.add(now)

        if now == start:
            if len(nodes) == n:
                return d[start]
            else:
                return False

        for i in range(n):
            if i == now:
                continue
            if graph[now][i] and visited[now][i] == False:
                stack.append(i)
                d[i] = d[now] + graph[now][i]
                visited[now][i] = True


def main():
    N = int(sys.stdin.readline().rstrip())
    graph = []
    for i in range(N):
        cost = list(map(int, sys.stdin.readline().rstrip().split()))
        graph.append(cost)
    
    cost = []
    for i in range(N):
        for j in range(N):
            if graph[i][j]:
                res = dfs(N, i, j, graph)
                if res:
                    cost.append(res)
    print(min(cost))


if __name__ == '__main__':
    main()

# <다른 사람 풀이>
# 참고 : https://ji-gwang.tistory.com/266
import sys

N = int(input()) #도시의 개수
travel_cost = [list(map(int, input().split())) for _ in range(N)]
min_value = sys.maxsize #출력할 최소값 정의


def dfs_backtracking(start, next, value, visited): #시작도시번호,다음도시번호,비용,방문 도시
    global min_value

    if len(visited) == N: #만약 방문한 도시가 입력받은 도시의 개수라면
        if travel_cost[next][start] != 0: #마지막 도시에서 출발 도시로 가는 비용이 0이 아니라면(즉,갈수 있다면)
            min_value = min(min_value, value + travel_cost[next][start]) #더한 값을 저장되어있는 최소값과 비교해서 대입
	return
    for i in range(N): #도시의 개수 만큼 반복문을 돈다.
        #만약 현재 도시에서 갈 수 있는 도시의 비용이 0이 아니고 이미 방문한 도시가 아니며 그 비용값이 저장되어있는 최소값보다 작다면
        if travel_cost[next][i] != 0 and i not in visited and value < min_value: 
            visited.append(i) #그 도시를 방문목록에 추가
            dfs_backtracking(start, i, value + travel_cost[next][i], visited) #그 도시를 방문한다.
            visited.pop() #방문을 완료했다면 방문목록 해제


#도시마다(0~3) 출발점을 지정
for i in range(N):
    dfs_backtracking(i, i, 0, [i])

print(min_value)