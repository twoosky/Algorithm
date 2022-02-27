# import sys

# def solution(step):
#     cnt = 0
#     res = 0
#     for i in range(len(step)-1):
#         if cnt < 2:
#             res += step[i]
#             cnt += 1
#         else:
#             cnt = 0
#         if i == len(step)-2 and cnt == 2:
#             res -= step[i]
#     res += step[i+1]
#     print(res)
        

# if __name__ == '__main__':
#     N = int(sys.stdin.readline().rstrip())
#     step = []
#     for _ in range(N):
#         step.append(int(sys.stdin.readline().rstrip()))
#     solution(step)

import sys

def solution(step):
    cnt = 0
    res = step[0]
    i = 0
    while True:
        if i == len(step)-1 and cnt == 2:
            res -= step[i]
            res += step[i+1]
            break
        if cnt > 1:
            res += step[i+2]
            cnt = 0
            i = i+2
        elif step[i+1] >= step[i+2]:
            res += step[i+1]
            cnt += 1
            i = i+1
        else:
            res += step[i+2]
            i = i+2
        

        
        

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    step = []
    for _ in range(N):
        step.append(int(sys.stdin.readline().rstrip()))
    solution(step)