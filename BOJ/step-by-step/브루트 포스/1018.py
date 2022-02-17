import sys

def change(i, j, *board):
    if board[i][j] == 'W':
        board[i+1][j] = 'B'
        board[i][j+1] = 'B'
    else:
        board[i+1][j] = 'W'
        board[i][j+1] = 'W'

N, M = map(int, sys.stdin.readline().rstrip().split())

board = []

for _ in range(N):
    x = sys.stdin.readline().rstrip()
    board.append(x)

cnt = 0
for i in range(N):
    for j in range(M):
        if i == N-1 and j == M-1:
            break
        if i == N-1:
            if board[i][j] == board[i][j+1]:
                cnt += 1
                if board[i][j] == "W":
                    board[i][j+1] = "B"
                else:
                    board[i][j+1] = "W"
                
        elif j == M - 1:
            if board[i][j] == board[i+1][j]:
                cnt += 1
                if board[i][j] == "W":
                    board[i+1][j] = "B"
                else:
                    board[i+1][j] = "W"
        else:
            if board[i][j] == board[i+1][j] or board[i][j] == board[i][j+1]:
                cnt += 1
                if board[i][j] == "W":
                    board[i+1][j] = "B"
                    board[i][j+1] = "B"
                else:
                    board[i+1][j] = "W"
                    board[i][j+1] = "W"

print(cnt)