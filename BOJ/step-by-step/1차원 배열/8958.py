# <내 풀이>
import sys

N = int(sys.stdin.readline().rstrip())
score = 0

for _ in range(N):
    input = list(sys.stdin.readline().rstrip().split("X"))
    for i in input:
        size = len(i)
        score += (size*(size+1))//2
    print(score)
    score = 0

# <다른 사람 풀이>  *BEST*
import sys

N = int(sys.stdin.readline().rstrip())

for _ in range(N):
    M = sys.stdin.readline().rstrip()
    flag = 0
    score = 0
    for i in M:
        if(i == 'O'):
            flag += 1
            score += flag
        else:
            flag = 0
    print(score)
