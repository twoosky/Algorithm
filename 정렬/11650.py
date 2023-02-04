import sys

N = int(sys.stdin.readline().rstrip())

inputList = []
for _ in range(N):
    nums = list(map(int, sys.stdin.readline().rstrip().split()))
    inputList.append(nums)

inputList.sort()

for num in inputList:
    print(num[0], num[1])


