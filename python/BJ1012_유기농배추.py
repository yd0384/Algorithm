# 맨위 구문 삽입해야 재귀 오류 안걸림, global list를 테스트케이스마다 초기화해줘야함
import sys
sys.setrecursionlimit(10 ** 6)

board = list()
def find(i, j, N, M):
    global board
    board[i][j]=-1
    if(i>0):
        if board[i-1][j]==1:
            find(i-1,j,N,M)
    if(j>0):
        if board[i][j-1]==1:
            find(i,j-1,N,M)
    if(i<N-1):
        if board[i+1][j]==1:
            find(i+1,j,N,M)
    if(j<M-1):
        if board[i][j+1]==1:
            find(i,j+1,N,M)
T = int(input())
for _ in range(T):
    M, N, K = [int(z) for z in input().split(' ')]
    result=0
    board=list()
    for n in range(N):
        board.append([0]*M)
    for __ in range(K):
        y, x = [int(z) for z in input().split(' ')]
        board[x][y] = 1
    for i in range(N):
        for j in range(M):
            if board[i][j]==1:
                find(i,j,N,M) 
                result+=1
    print(result)