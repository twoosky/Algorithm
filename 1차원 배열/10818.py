import sys

N = int(input())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

arr.sort()
print(arr[0], arr[len(arr) - 1])

# <다른 풀이 방법>
# - arr[len(arr) - 1] 대신! arr[-1] 사용하기
# - print(min(arr), max(arr))

# <알게된 점>
# - 오름차순: 변수명.sort()
# - 내림차순: sort(reverse = True)

