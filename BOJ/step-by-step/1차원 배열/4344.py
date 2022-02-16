# <내 풀이>
# 입력값을 변수와 리스트로 나눠 저장하는 방법을 몰라.. 굉장히 비효율적인 코드
import sys

C = int(sys.stdin.readline().rstrip())

for _ in range(C):
    N = list(map(int, sys.stdin.readline().rstrip().split()))
    count = 0
    sum = 0
    for i in range(1, N[0] + 1):
        sum += N[i]
    avg = sum / N[0]

    for i in range(1, N[0] + 1):
        if(N[i] > avg):
            count += 1
    
    res = (count/N[0])*100
    print('%.3f%%' %(res))

# <다른 사람 풀이> *BEST*
import sys

C = int(sys.stdin.readline().rstrip())

for _ in range(C):
    N, *scores = list(map(int, sys.stdin.readline().rstrip().split()))
    count = 0
    avg = sum(scores)/N

    for score in scores:
        if avg < score:
            count += 1
    
    res = (count/N) * 100
    print('%.3f%%' %(res))


# <알게된 점>
# - 변수와 리스트에 나눠 저장 ***
# N, *scores = list(map(int, sys.stdin.readline().rstrip().split()))
# - % 문자 출력 시 앞에 % 붙여줘야됨 
# ex) %%
# - 실수형 소수점 자리 출력
# %.{n}f ({n}은 원하는 소수점 자리)
# print('%.3f' %(res))

    