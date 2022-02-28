# # <내 풀이>
# import sys

# def solution(n):
#     cnt = 0
#     d = [0, 1, 1]
#     if n <= 3:
#         print(d[n-1])
#         return
    
#     for i in range(4, n+1):
#         if i%2 == 0 and i%3 == 0:
#             d.append(min(d[(i//2)-1] + 1, d[(i//3)-1] + 1))
#             continue
#         if i%2 == 0:
#             d.append(min(d[i-2] + 1, d[(i//2)-1] + 1))
#         elif i%3 == 0:
#             d.append(min(d[i-2] + 1, d[(i//3)-1] + 1))
#         else:
#             d.append(d[i-2] + 1)
#     print(d[-1])

# if __name__ == '__main__':
#     N = int(sys.stdin.readline().rstrip())
#     solution(N)

# <다른 사람 풀이> 
# : 방식은 같으나 더 깔끔
import sys

def solution(n):
    d = [0, 1]

    for i in range(3, n+1):
        d.append(d[i-2] + 1)
        if i%2 == 0:
            d[i-1] = min(d[i-1], d[(i//2)-1] + 1)
        if i%3 == 0:
            d[i-1] = min(d[i-1], d[(i//3)-1] + 1)
    print(d[-1])

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    solution(N)
