import sys

N = int(sys.stdin.readline().rstrip())

res = set()

for _ in range(N):
    res.add(int(sys.stdin.readline().rstrip()))
    
res = sorted(res)
for num in res:
    print(num)

# <알게된 점>
# - 리스트는 내장함수로 sort()를 갖지만, 
#   set에서 정렬하기 위해선 sorted(set이름) 사용해야함


# [시간복잡도 O(nlogn)인 정렬 알고리즘]
# <병합 정렬>
import sys

# [divide]
# 리스트 요소가 1개가 될때까지 나눔 / 왼쪽,오른쪽 merge
def merge_sort(list):
    if len(list) <= 1:
        return list
    mid = len(list)//2
    left = list[:mid]
    right = list[mid:]
    left = merge_sort(left)
    right = merge_sort(right)
    return merge(left, right)

# [merge]
#1. 분리한 왼쪽리스트, 오른쪽 리스트의 각각 첫번째 요소를 비교해 더 작은 값을 결과 리스트에 저장
#2. 저장한 값은 리스트에서 지움. 
#3. 두 리스트 모두 요소가 하나도 안남을 때까지 반복
def merge(left, right):
    l=r=0
    mergedList = []
    while len(left) > l and len(right) > r:
        if left[l] < right[r]:
            mergedList.append(left[l])
            l += 1
        else:
            mergedList.append(right[r])
            r += 1
    # while문 빠져 나온 후, left 혹은 right에 남은 요소들 mergeList에 넣어주기
    mergedList += left[l:]
    mergedList += right[r:]
    return mergedList

N = int(sys.stdin.readline().rstrip())

unSortedList = []
for _ in range(N):
    unSortedList.append(int(sys.stdin.readline().rstrip()))

sortedList = merge_sort(unSortedList)

for num in sortedList:
    print(num)

# <병합 정렬>
# 시간 복잡도: O(nlogn)
# 참고: https://velog.io/@uoayop/BOJ-2751-%EC%88%98-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B02Python
# 참고: https://eunhee-programming.tistory.com/105