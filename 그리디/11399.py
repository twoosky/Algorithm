import sys

def solution(time):
    time.sort()
    answer = [time[0]]
    for i in range(1, len(time)):
        answer.append(answer[-1] + time[i])
    print(sum(answer))

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    time = list(map(int, sys.stdin.readline().rstrip().split()))
    solution(time)