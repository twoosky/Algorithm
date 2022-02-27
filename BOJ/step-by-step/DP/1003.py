# <내 풀이_1> - 실패(런타임 에러)
import sys

fibo = [[0]*2 for _ in range(41)]

def solution(n):
    if n == 0:
        fibo[n][0] = 1
        return fibo[n]
    elif n == 1:
        fibo[n][1] = 1
        return fibo[n]
    if fibo[n][0] != 0 and fibo[n][1] != 0:
        return fibo[n]
    else:
        tmp1 = solution(n-1)
        tmp2 = solution(n-2)
        fibo[n] = [tmp1[0]+tmp2[0], tmp1[1] + tmp2[1]]
        return fibo[n]
    
if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    N = []
    for _ in range(T):
        N.append(int(sys.stdin.readline().rstrip()))
    for n in N:
        solution(n)
        print(fibo[n][0], fibo[n][1])

# <내 풀이_2> - 실패(런타임 에러)
# 내가 뭐 잘못 이해하고 있나봄... 왜 안돼 !!!!!!!!!!!!
import sys

cnt = [[1, 0], [0, 1]]

def solution(n):
    if n == 0 or n == 1:
        return
    elif len(cnt) > n:
        return
    for i in range(len(cnt), n+1):
        cnt.append([cnt[i-2][0] + cnt[i-1][0], cnt[i-2][1] + cnt[i-1][1]])

if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    N = []
    for _ in range(T):
        N.append(int(sys.stdin.readline().rstrip()))
    for n in N:
        solution(n)
        print(cnt[n][0], cnt[n][1])

# <내 풀이_3> - 성공
# 위 코드랑 뭐가 다른지 모르겠음 얘는 왜 성공하냐
import sys

cnt = [[1, 0], [0, 1]]

def solution(n):
    if len(cnt) <= n:
        for i in range(len(cnt), n+1):
            cnt.append([cnt[i-2][0] + cnt[i-1][0], cnt[i-2][1] + cnt[i-1][1]])

if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    N = []
    for _ in range(T):
        N.append(int(sys.stdin.readline().rstrip()))
    for n in N:
        solution(n)
        print(cnt[n][0], cnt[n][1])


# <다른 사람 풀이>
from sys import stdin

T = int(input())

l = [int(stdin.readline()) for _ in range(T)]
f = [[1, 0], [0, 1]]
for i in range(2, max(l)+1):
    f.append([f[i-2][0]+f[i-1][0], f[i-2][1]+f[i-1][1]])
for i in l:
    print(' '.join(map(str, f[i])))

# <알게된 점>
# - TypeError: 'int' object is not subscriptable
# : 인덱스를 갖지 않는 값에 인덱싱을 할 경우 발생하는 오류

# - 2차원 리스트 초기화
# 반드시 컴프리헨션 사용 
# ex) array = [[0]*4 for _ in range(3)]
# -> [[0,0,0,0], [0,0,0,0], [0,0,0,0]]

# - 컴프리헨션 사용하지 않고 2차원 리스트 선언하면 안됨
# 문제점 ex) 
# array = [[0]*4]*4
# array[0][1] = 5 
# [[0,5,0,0], [0,5,0,0], [0,5,0,0]]
# -> 내부적으로 포함된 3개의 리스트가 모두 동일한 객체에 대한 3개의 레퍼런스로
#    인식되기 때문에 내부 리스트값이 모두 변동됨
# : 따라서 컴프리헨션을 사용해 2차원 리스트를 초기화해야함 !
