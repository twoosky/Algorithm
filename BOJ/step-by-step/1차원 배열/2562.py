# 최댓값

# <내가 작성한 코드>
'''
import sys

max = 0
idx = 0
for i in range(9):
    N = int(sys.stdin.readline().rstrip())
    if max < N:
        max = N
        idx = i

print(max)
print(idx + 1)
'''

# <다른 사람 풀이>
import sys

N = []
for _ in range(9):
    N.append(sys.stdin.readline().rstrip())

print(max(N))
print(N.index(max(N)) + 1)

# <알게된 점>
# - list에서 특정값의 인덱스 찾기
#  : 리스트명.index(특정값)
#  ex) arr.index(30)

# - list에서 특정값이 몇개 있는지 찾기 
#  : 리스트명.count(특정값)
#  ex) arr.count(30)

# 리스트 내장함수 적극 활용하기!