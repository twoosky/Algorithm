import sys

T = int(sys.stdin.readline().rstrip())

for _ in range(T): 
    A, B = map(int, sys.stdin.readline().rstrip().split())
    print(A + B)

# 이것이 취업을 위한 코딩테스트다 446p
# 입력 개수가 많은 경우 input()은 너무 느림
# import sys
# sys.stdin.readline().rstrip() 권장!

# sys 라이브러리르 사용할 때는 한 줄 입력을 받고 나서 rstrip() 함수 호출 필수
# readline()으로 입력하면 엔터가 줄 바꿈 기호로 입력되는데,
# 이 공백 문자를 제거하려면 `rstrip()` 함수를 사용해야 한다.  