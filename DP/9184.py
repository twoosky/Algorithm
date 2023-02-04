import sys

res = dict()

def w(a, b, c):
    abc = str(a)+str(b)+str(c)
    if a <= 0 or b <= 0 or  c <= 0:
        return 1
    elif abc in res.keys():
        return res[abc]
    elif a > 20 or b > 20 or c > 20:
        res[abc] = w(20, 20, 20)
        return res[abc]
    elif a < b and b < c:
        res[abc] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return res[abc]
    else:
        res[abc] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        return res[abc]

if __name__ == '__main__':
    answer = []
    while True:
        a, b, c = map(int, sys.stdin.readline().rstrip().split())
        if a == -1 and b == -1 and c == -1:
            break
        num = w(a, b, c)
        answer.append([a, b, c, num])
    for ans in answer:
        print(f"w({ans[0]}, {ans[1]}, {ans[2]}) = {ans[3]}")

# <알게된 점>
# - 3차원 리스트 초기화
# ex) 0으로 초기화한 dp[21][21][21] 리스트
# dp = [[[0 for _ in range(21)] for _ in range (21)] for _ in range (21)]
        