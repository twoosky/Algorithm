import sys

N = int(sys.stdin.readline().rstrip())

inputList = []

for _ in range(N):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    inputList.append([y, x])

inputList.sort()

for num in inputList:
    print(num[1], num[0])

# <알게된 점>
# - 2차원 리스트를 sort()하면 첫번째 요소를 기준으로 정렬됨