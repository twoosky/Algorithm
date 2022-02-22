# import sys

# N = int(sys.stdin.readline().rstrip())

# list = []
# for _ in range(N):
#     list.append(int(sys.stdin.readline().rstrip()))

# list.sort()
# avg = sum(list)/len(list)
# mid = list[len(list)//2]

# range = list[-1] - list[0]

# cnt = [0] * 4000
# for num in list:
#     cnt[num] = list.count(num)

# res = []
# maxCnt = max(cnt)
# for i in range(4000):
#     if cnt[i] == maxCnt:
#         res.append(i)

# if len(res) != 1:
#     print(res[1])
# else:
#     print(res)


import sys
from collections import Counter

N = int(sys.stdin.readline().rstrip())

numbers = []
for _ in range(N):
    numbers.append(int(sys.stdin.readline().rstrip()))

numbers.sort()

cnt = Counter(numbers).most_common(2)

print(round(sum(numbers)/len(numbers)))
print(numbers[len(numbers) // 2])

if len(numbers) > 1:
    if cnt[0][1] == cnt[1][1]:
        print(cnt[1][0])
    else:
        print(cnt[0][0])
else:
    print(cnt[0][0])

print(max(numbers) - min(numbers))
