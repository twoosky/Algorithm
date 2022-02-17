# <내 풀이>
import sys

def solve(n):
    sum = n

    while(n != 0):
        sum += (n % 10)
        n = n // 10
    
    return sum

N = int(sys.stdin.readline().rstrip())

res = []

for i in range(N):
    if solve(i) == N:
        print(i)
        break

    if i == N-1:
        print(0)

# <다른 사람 풀이>
import sys

N = int(sys.stdin.readline().rstrip())

for i in range(1, N + 1):
    # str 함수를 통해 i의 각 자리수를 리스트에 넣어줌
    strList = list(map(int, str(i)))
    # i와 i의 각 자리수를 가진 리스트의 합을 더함
    # ex) i = 245, strList = [2, 4, 5]
    # -> 245 + (2 + 4 + 5) 
    res = i + sum(strList)
    if res == N:
        print(i)
        break

    if i == N:
        print(0)

# <알게된 점>
# - 문자열을 쪼개 list로 저장하는 방법
# str() 함수 활용
# ex) list(map(int, str(245)))
#     정수 245 -> [2, 4, 5]

# - 리스트 각 요소를 더한 합 구하기
# sum(list명)

# 시간은 내 풀이가 더 적게 나옴 왜지
# 그래도 밑에 코드가 깔끔하니 문자열을 활용해보자


    
    









