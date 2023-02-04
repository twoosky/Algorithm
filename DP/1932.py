# <내 풀이>
# : 0번째 줄부터 아래 줄 값 비교해 아래 줄 값 계산
# 지금은 이해되는데 나중되면 뭔소린지 모르겠지 ㅋ
# 1149번이랑 비슷 같이 풀어볼 것
import sys

def solution(tri):
    tmp = [item[:] for item in tri]
    for i in range(len(tri)-1):
        for j in range(len(tri[i])):
            tmp[i+1][j] = max(tmp[i][j] + tri[i+1][j], tmp[i+1][j])
            tmp[i+1][j+1] = max(tmp[i][j] + tri[i+1][j+1], tmp[i+1][j+1])
    print(max(tmp[-1]))


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    tri = []
    for _ in range(N):
        num = list(map(int, sys.stdin.readline().rstrip().split()))
        tri.append(num)
    solution(tri)

# <다른 사람 풀이> 
# : 1번째 줄부터 윗 줄 값 비교해 해당 줄 값 계산
# 이게 더 깔끔하다
n=int(input())
d=[]
for i in range(n):
  d.append(list(map(int, input().split())))

for i in range(1,n):
  for j in range(len(d[i])):
    if j==0:
      d[i][j]=d[i][j]+d[i-1][j]
    elif j==len(d[i])-1: 
      d[i][j]=d[i][j]+d[i-1][j-1]
    else:
      d[i][j]=max(d[i-1][j-1],d[i-1][j])+d[i][j]
print(max(d[n-1]))

# <알게된 점>
# 2차원 리스트의 깊은 복사 *****
# ex) scailing 방법
# list_a = [[[0]*3 for _ in range(5)] for _ in range(10)]
# list_b = [item[:] for item in list_a]

# 파이썬 2차원 리스트 초기화 참고 : https://juun42.tistory.com/14
# 파이썬 2차원 리스트 깊은 복사 참고 : https://velog.io/@emplam27/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EB%A6%AC%EC%8A%A4%ED%8A%B8%EC%9D%98-%EA%B9%8A%EC%9D%80%EB%B3%B5%EC%82%AC%EB%8A%94-deepcopy%EA%B0%80-%EB%B9%A0%EB%A5%BC%EA%B9%8C-slicing%EC%9D%B4-%EB%B9%A0%EB%A5%BC%EA%B9%8C