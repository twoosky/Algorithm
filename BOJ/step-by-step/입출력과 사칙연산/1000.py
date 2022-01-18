A, B = map(int, input().split())

print(A + B)

# input()은 입력된 값을 문자열로 인식해 변수에 저장한다.
# 연산 시 int로 형변환 필수
# int(input().split()) 안되나? 안됨 -> int 함수는 리스트를 정수형으로 바꿀 수 없으므로 오류
# map(적용할 함수, 반복 가능한 자료형) 함수를 사용해야 한다.

# map(int, input().split())에 대한 설명 참고
# https://ccamppak.tistory.com/entry/mapint-inputsplit%EC%97%90-%EB%8C%80%ED%95%B4?category=1026074
