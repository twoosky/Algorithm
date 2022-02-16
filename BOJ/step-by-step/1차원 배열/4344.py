import sys

C = int(sys.stdin.readline().rstrip())

for _ in range(C):
    N = list(map(int, sys.stdin.readline().rstrip().split()))
    count = 0
    sum = 0
    for i in range(1, N[0]):
        sum += N[i]
    avg = sum / N[0]

    for i in range(1, N[0]):
        if(N[i] > avg):
            count += 1
    
    res = (count/N[0])*100
    print('%.3f%%' %(res))

# <알게된 점>
# % 문자 출력 시 앞에 % 붙여줘야됨 
# ex) %%
# 실수형 소수점 자리 출력
# %.{n}f ({n}은 원하는 소수점 자리)
# print('%.3f' %(res))

    