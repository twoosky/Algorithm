# <내 풀이>
import sys

input = list()

for _ in range(10):
    temp = int(sys.stdin.readline().rstrip())
    input.append(int(temp % 42))

compare = list()
cnt = 0

for i in range(10):
    if(input[i] not in compare):
        compare.append(input[i])
        cnt += 1
    
print(cnt)

# <다른사람 풀이 #1 >
# : list.count(N) 사용
# list 내 N값이 몇 개 있는지 알려주는 함수
import sys

result = list()
count = 0

for i in range(10):
    N = int(sys.stdin.readline().rstrip())
    N = int(N % 42)
    if(result.count(N) == 0):
        result.append(N)
        count += 1

print(count)

# <다른사람 풀이 #2> *BEST*
# set 사용
import sys

res = set()
cnt = 0

for i in range(10):
    N = int(sys.stdin.readline().rstrip())
    res.add(int(N%42))

print(len(cnt))


# <알게된 점>
# set()
# - 중복을 허용하지 않는다.
# - 순서가 없다.
# - 이미 등장한 적이 있는 데이터인지 체크할 때 효과적

# - 초기화 : set() 또는 {} 사용
# 1) data = set([1,1,2,3,4,4])
# 2) data = {1,1,2,3,4,4}

# - 집합 자료형의 연산
# a = set([1,2,3,4,5])
# b = set([3,4,5,6,7])
# 합집합 a:b
# 교집합 a&b
# 차집합 a-b

# - 집합 자료형 관련 함수
# 원소추가: data.add()
# 새로운 원소 여러개 추가: data.update([4,5])
# 특정값을 갖는 원소 삭제 : data.remove(3)

# 이것이 취업을 위한 코테 430p
