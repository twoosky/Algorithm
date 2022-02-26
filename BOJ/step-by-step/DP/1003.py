# # <내 풀이> - 실패 1(런타임 에러)
# import sys

# fibo = [[0]*2 for _ in range(41)]

# def solution(n):
#     if n == 0:
#         fibo[n][0] = 1
#         return fibo[n]
#     elif n == 1:
#         fibo[n][1] = 1
#         return fibo[n]
#     if fibo[n][0] != 0 and fibo[n][1] != 0:
#         return fibo[n]
#     else:
#         tmp1 = solution(n-1)
#         tmp2 = solution(n-2)
#         fibo[n] = [tmp1[0]+tmp2[0], tmp1[1] + tmp2[1]]
#         return fibo[n]
    
# if __name__ == '__main__':
#     T = int(sys.stdin.readline().rstrip())
#     N = []
#     for _ in range(T):
#         N.append(int(sys.stdin.readline().rstrip()))
#     for n in N:
#         solution(n)
#         print(fibo[n][0], fibo[n][1])

# <내 풀이> - 실패 2(런타임 에러)
# 내가 뭐 잘못 이해하고 있나봄... 왜 안돼 !!!!!!!!!!!!
import sys

cnt = [[1, 0], [0, 1]]

def solution(n):
    if len(cnt) <= n:
        for i in range(len(cnt), n+1):
            cnt.append([cnt[i-2][0] + cnt[i-1][0], cnt[i-2][1] + cnt[i-1][1]])

if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    N = []
    for _ in range(T):
        N.append(int(sys.stdin.readline().rstrip()))
    for n in N:
        solution(n)
        print(cnt[n][0], cnt[n][1])


# <다른 사람 풀이>
# from sys import stdin
# T = int(input())
# l = [int(stdin.readline()) for _ in range(T)]
# f = [[1, 0], [0, 1]]
# for i in range(2, max(l)+1):
#     f.append([f[i-2][0]+f[i-1][0], f[i-2][1]+f[i-1][1]])
# for i in l:
#     print(' '.join(map(str, f[i])))