# <내 풀이>
# [아이디어]
# 1. 찾고자하는 수를 첫번째 배열에서 찾으면 해당 위치에서 앞 뒤로 옮겨가며 같은 수를 찾아 개수 셈
# 2. 두번째 배열에서 중복된 값을 찾을 수 있으므로 만약 이전에 찾았던 수라면 이진 탐색 하지 않고 딕셔너리의 해당 수 value 반환
# 1번 아이디어까지 작성한 코드는 시간초과, 2번 아이디어를 추가하니 성공
# 성공은 했는데 2번 아이디어가 왜 시간을 줄여주는지 모르겠음
# 두번째 배열에서 중복된 값을 입력할 수도 있는건가? 중복없다는 말을 안했으니까?
# import sys

# def main():
#     N = int(sys.stdin.readline().rstrip())
#     arr1 = list(map(int, sys.stdin.readline().rstrip().split()))
#     M = int(sys.stdin.readline().rstrip())
#     arr2 = list(map(int, sys.stdin.readline().rstrip().split()))

#     num = dict()
#     answer = []
#     arr1.sort()
#     for i in range(M):
#         start = 0
#         end = N-1
#         mid = N//2
#         cnt = 0
#         if arr2[i] not in num:
#             num[arr2[i]] = 0
#         else:
#             answer.append(num[arr2[i]])
#             continue
#         while True:
#             if start > mid:
#                 cnt = 0       
#                 break
#             elif arr1[mid] == arr2[i]:
#                 cnt += 1
#                 for j in range(mid-1, -1, -1):
#                     if arr1[j] == arr1[mid]:
#                         cnt += 1
#                     else:
#                         break
#                 for j in range(mid+1, N):
#                     if arr1[j] == arr1[mid]:
#                         cnt += 1
#                     else: 
#                         break
#                 break
#             elif arr1[mid] < arr2[i]:
#                 start = mid + 1
#             elif arr1[mid] > arr2[i]:
#                 end = mid - 1
#             mid = (start+end)//2
#         answer.append(cnt)
#         num[arr2[i]] = cnt
    
#     for ans in answer:
#         print(ans, end=' ')
                

# if __name__ == '__main__':
#     main()


# <다른 사람 풀이>
# 참고: https://velog.io/@ledcost/%EB%B0%B1%EC%A4%80-10816-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%88%AB%EC%9E%90-%EC%B9%B4%EB%93%9C-2-%EC%8B%A4%EB%B2%844-%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89
import sys

def binary_search(n, m, arr1, arr2):
    count = dict()
    for i in range(n):
        if arr1[i] not in count:
            count[arr1[i]] = 1
        else:
            count[arr1[i]] = count[arr1[i]] + 1
    
    answer = []
    arr1.sort()
    for i in range(m):
        start = 0
        end = n-1
        mid = n//2
        while True:
            if start > end:
                answer.append(0)
                break
            elif arr1[mid] == arr2[i]:
                answer.append(count[arr1[mid]])
                break
            elif arr1[mid] < arr2[i]:
                start = mid + 1
            elif arr1[mid] > arr2[i]:
                end = mid - 1
            mid = (end+start)//2
        
    for ans in answer:
        print(ans, end=' ')
def main():
    N = int(sys.stdin.readline().rstrip())
    arr1 = list(map(int, sys.stdin.readline().rstrip().split()))
    M = int(sys.stdin.readline().rstrip())
    arr2 = list(map(int, sys.stdin.readline().rstrip().split()))
    binary_search(N, M, arr1, arr2)

if __name__ == '__main__':
    main()

