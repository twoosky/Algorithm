import sys

N = sys.stdin.readline().rstrip()

list = list(map(int, N))

list.sort(reverse = True)

for num in list:
    print(num, end='')    