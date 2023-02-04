import sys
from itertools import permutations

def solution(N, M):
    array = []
    for i in range(1, N+1):
        array.append(i)
    answer = set(permutations(array, M))
    answer = sorted(answer)
    for ans in answer:
        for i in range(M):
            print(ans[i], end=' ')
        print() 


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().rstrip().split())
    solution(N, M)

# <알게된 점>
# 이것이 코딩테스트다 p452
# * permutations
# : r개의 데이터를 뽑아 일렬로 나열하는 모든 경우(순열) 계산
# ex) from itertools import permutations
# data = ['A', 'B', 'C']
# result = list(permutation(data, 3))
# -> 리스트 ['A', 'B', 'C']에서 3개(r=3)을 뽑아 나열하는 경우 출력

# * combinations
# : r개의 데이터를 뽑아 순서를 고려하지 않고 나열하는 모든 경우(조합) 계산
# ex) from itertools import combinations
# data = ['A', 'B', 'C']
# result = list(combinations(data, 2))
# -> [('A', 'B'), ('A', 'C'), ('B', 'C')]

# * product
# : permutations와 같이 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우(순열) 계산
# : 다만, 원소를 중복하여 뽑는다 (중복 허용!)
# : 뽑고자 하는 데이터의 수를 repeat 속성값으로 넣어준다.
# ex) from itertools import product
# result = list(product(data, repeat=2))
# -> ('A', 'C'), ('C', 'A') 이렇게 중복 허용해 순열 출력 

# * combinations_with_replacement
# : combinations와 같은 역할 대신, 중복 허용
# ex) from itertools import combinations_with_replacement
# result = list(combinations_with_replacement(data, 2))
# -> ('A', 'A'), ('A', 'B') 이렇게 중복 허용해 조합 출력