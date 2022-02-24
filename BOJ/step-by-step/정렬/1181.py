# <내 풀이>
import sys

def solution(words):
    words = sorted(words)
    for i in range(1, 51):
        for word in words:
            if len(word) == i:
                print(word)



if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    words = set()
    for _ in range(N):
        words.add(sys.stdin.readline().rstrip())
    solution(words)

# <sorted() 함수 key 속성 사용한 풀이> *BEST*
import sys

def solution(words):
    alphaSorted = sorted(words)
    # 길이 순 정렬 (정렬 라이브러리, 람다 사용)
    lenSorted = sorted(alphaSorted, key=lambda str: len(str))
    for word in lenSorted:
        print(word)

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    words = set()
    for _ in range(N):
        words.add(sys.stdin.readline().rstrip())
    solution(words)

# <알게된 점>
# - sorted(, key=) 로 원하는 기준에 따라 정렬 가능!
# : 정렬 라이브러리는 최악의 경우에도 시간 복잡도 O(NlogN) 보장

# - 람다 표현 식
# ex) (lambda a, b: a + b)(값1, 값2)

# - if __name__ == '__main__' : 
# 사용하자 
