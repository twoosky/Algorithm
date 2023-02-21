N = int(input())

for i in range(N):
    for j in range(i+1):
        print("*", end='')
    print()

# <다른 풀이 방법>
# - print()에서 문자열("*")을 개수만큼 곱해 출력
'''
N = int(input())

for i in range(1, 1+N):
    print("*"*i)
'''

# <알게된 점>
# - print()에서 줄바꿈을 없애려면 print(  , end='') 하면 된다.
#   default는 print(  , end='\n')
# - print할 때 문자열에 변수 곱하면 변수 값만큼 문자열이 반복 출력된다.
# - for문을 최대한 덜 사용하는 것이 시간복잡도 면에서 좋다.