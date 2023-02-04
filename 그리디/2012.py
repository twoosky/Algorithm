# <다른 사람 풀이>
# 참고: https://velog.io/@ju_h2/Python-%EB%B0%B1%EC%A4%80-2012.-%EB%93%B1%EC%88%98%EB%A7%A4%EA%B8%B0%EA%B8%B0-%ED%92%80%EC%9D%B4-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%ED%83%90%EC%9A%95-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EA%B7%B8%EB%A6%AC%EB%94%94-%EA%B5%AC%ED%98%84-2
import sys

def solution(n, score):
    score.sort()
    answer = 0

    ans = 0
    for i in range(1, n+1):
        ans += abs(i-score[i-1])
    print(ans)

def main():
    N = int(sys.stdin.readline().rstrip())
    score = []
    for _ in range(N):
        score.append(int(sys.stdin.readline().rstrip()))
    solution(N, score)

if __name__ == '__main__':
    main()

# <알게된 점>
# 절대값: abs()