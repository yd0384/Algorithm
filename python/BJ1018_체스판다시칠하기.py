M, N = map(int, input().split(' '))
board = list()
for m in range(M):
    board.append(input())
chessboard1 = list()
chessboard2 = list()
for i in range(8):
    if i%2==0:
        chessboard1.append('WB'*4)
        chessboard2.append('BW'*4)
    else:
        chessboard1.append('BW'*4)
        chessboard2.append('WB'*4)

result=64
for i in range(M-8+1):
    for j in range(N-8+1):
        count1=0
        count2=0
        for k in range(8):
            for l in range(8):
                if board[i+k][j+l] != chessboard1[k][l]:
                    count1+=1
                if board[i+k][j+l] != chessboard2[k][l]:
                    count2+=1
        result=min(result, min(count1, count2))
print(result)