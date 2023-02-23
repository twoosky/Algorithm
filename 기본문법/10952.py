while 1:
    A, B = map(int,input().split())
    if A == 0 and B == 0: break
    print(A+B)

# <튜플 사용한 풀이>
'''
while 1:
    A = tuple(map(int, input().split()))
    if A[0] == 0 and A[1] == 0: break
    print(A[0]+A[1]) 
'''

# <튜플이란?>
# - 튜플은 list와 같이 인덱스로 접근가능
# - 대신 튜플 내 값 변경 불가능
# - 튜플은 리스트에 비해 공간 효율적이고, 원소로 여러 타입을 가질 수 있다.
# : 우선순위큐 최단 경로 알고리즘에서는 '비용'과 '노드 번호'라는 서로 다른 성질의 데이터를 (비용, 노드 번호) 형태로 튜플로 묶어 관리한다.
