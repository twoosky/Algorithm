# <내 풀이>
# - 시간초과 발생
# - O(NlogN)으로 수행해야하는데 index()는 O(N)임
# - 심지어 반복문 내에서 index() 호출했으니 시간초과 발생할 수 밖에 ...
# - 이렇게 하면 시간복잡도 O(N2) 일듯 오마이갓 
import sys

def solution(X):
    compare = sorted(set(X), reverse = True)
    for x in X:
        answer = len(compare)-compare.index(x)-1
        print(answer, end=' ')


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    X = list(map(int, sys.stdin.readline().rstrip().split()))
    solution(X)

# <다른 사람 풀이>
import sys

def solution(X):
    sort_X = sorted(set(X))
    answer = dict()
    for i in range(len(sort_X)):
        answer[sort_X[i]] = i
    for x in X:
        print(answer[x], end=' ')


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    X = list(map(int, sys.stdin.readline().rstrip().split()))
    solution(X)

# <알게된 점>
# - list.index() 시간복잡도: O(N)
# - 딕셔너리 인덱스 참조 시간복잡도: O(1)'
# : dict[i]는 시간복잡도가 O(1)이므로 시간초과 발생 X
# 시간복잡도 고려해 여러 자료구조 적용해볼 것