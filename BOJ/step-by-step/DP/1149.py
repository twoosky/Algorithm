# <다른 사람 풀이>  *BEST*
# 참고 : https://namhandong.tistory.com/131
import sys

def solution(RGB):
    # 첫번째 집은 계산하지 않고, 두번째부터 시작해서 이전의 값들 중 같은 색을 제외한 min을 더해 줌
    for i in range(1, len(RGB)):
        # 빨간집
        RGB[i][0] = min(RGB[i-1][1], RGB[i-1][2]) + RGB[i][0]
        # 초록집
        RGB[i][1] = min(RGB[i-1][0], RGB[i-1][2]) + RGB[i][1]
        # 파란집
        RGB[i][2] = min(RGB[i-1][0], RGB[i-1][1]) + RGB[i][2]
    print(min(RGB[-1]))

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    RGB = []
    for _ in range(N):
        a, b, c = map(int, sys.stdin.readline().rstrip().split())
        RGB.append([a, b, c])
    solution(RGB)

# <냬 풀이> - 실패
# : 첫번째 집에서 가장 작은 수를 시작으로 하는 값만 구함
# 여 튼 실패 
import sys

select = []
cnt = 0

def solution(cost):
    global cnt
    if len(select) == 0:
        cnt += min(cost)
        select.append(cost.index(min(cost)))
    else:
        cost[select[-1]] = 1001
        cnt += min(cost)
        select.append(cost.index(min(cost)))

 
if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    for _ in range(N):
        a, b, c = map(int, sys.stdin.readline().rstrip().split())
        solution([a, b, c])
    print(cnt)