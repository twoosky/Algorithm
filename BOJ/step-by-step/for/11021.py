T = int(input())

for i in range(1, T+1):
    A, B = map(int, input().split())
    print(f'Case #{i}: {A+B}')

# 문자열과 변수 함께 출력하는 방법
# 1. f-string
# print(f'Case #{i}: {A+B}') - 앞에 f를 붙이고 {}로 변수 출력
# 2. 튜플로 인수 전달
# print('Case #%d: %d' %(i, A+B))