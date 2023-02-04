# <내 풀이>
# : 증맬루 하드코딩.. 이게 통과됐다니
import sys

def solution(n):
    arr = []
    num = ''
    for i in range(len(n)):
        if n[i] == '+' or n[i] == '-':
            arr.append(int(num))
            arr.append(n[i])
            num = ''
        else:
            num += n[i]
    arr.append(int(num))

    res = 0
    i = 0
    while i < len(arr):
        if arr[i] == '-':
            for j in range(i+1, len(arr)):
                if arr[j] == '-':
                    i = j
                    break
                elif arr[j] != '+':
                    res -= arr[j]
                i = len(arr)
            continue
        if arr[i] != '+':
            res += arr[i]
        i = i + 1
    print(res)

if __name__ == '__main__':
    N = sys.stdin.readline().rstrip()
    solution(N)

# <다른 사람 풀이>  *BEST*
# 참고 : https://pacific-ocean.tistory.com/228
import sys

def solution(arr):
    arr = list(arr.split('-'))
    res = 0
    for i in range(len(arr)):
        temp = list(map(int, arr[i].split('+')))
        if i == 0:
            res += sum(temp)
        else:
            res -= sum(temp)
    print(res)

if __name__ == '__main__':
    arr = sys.stdin.readline().rstrip()
    solution(arr)