# <내 풀이>
# 실패한 풀이..... 
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

board = []

for _ in range(N):
    board.append(list(sys.stdin.readline().rstrip()))

res = []

for i in range(N-7):
    for j in range(M-7):
        temp = board.copy()
        count = 0
        for n in range(i, i+8):
            for m in range(j, j+8):
                if m != j+7 and temp[n][m] == temp[n][m+1]:
                    count += 1
                    if temp[n][m] == 'W':
                        temp[n][m+1] = 'B'
                    else:
                        temp[n][m+1] = 'W'
                elif n != i+7 and temp[n][m] == temp[n+1][m]:
                    count += 1
                    if temp[n][m] == 'W':
                        temp[n+1][m] = 'B'
                    else:
                        temp[n+1][m] = 'W'   
        print(count)      
        res.append(count)

print(min(res))


# <다른 사람 풀이>  *BEST*
# 참고 : https://bambbang00.tistory.com/43
# 상상도 못한 ..... 풀이 .. 문제 제대로 읽자.. 
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

board = []

for _ in range(N):
    board.append(list(sys.stdin.readline().rstrip()))

res = []

for n in range(N-7):
    for m in range(M-7):
        white = 0
        black = 0
        for i in range(n, n+8):
            for j in range(m, m+8):
                if (i + j) % 2 == 0:
                    # W로 시작하는 경우
                    if board[i][j] != 'W':
                        white += 1
                    # B로 시작하는 경우
                    if board[i][j] != 'B':
                        black += 1
                
                else:
                    # B 옆에 W가 아닌 경우
                    if board[i][j] != 'W':
                        black += 1
                    # W 옆에 B가 아닌 경우
                    if board[i][j] != 'B':
                        white += 1
        res.append(min(white, black))
    
print(min(res))

# <알게된 점>
# - 리스트 복사 : list.copy()
# ex) list1 = list2
# 이렇게 하면 주소값이 복사되는 것임.
# 따라서 리스트 객체를 새로 생성하기 위해
# list1 = list2.copy() 사용해야 함

# - min(num1, num2)
# num1과 num2 중 더 작은 수 찾는 함수

                    
