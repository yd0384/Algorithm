import sys
N, M = [int(i) for i in input().split(' ')]
book=dict()
for n in range(1,N+1):
    book[n]=sys.stdin.readline().rstrip()
inv_book = {v:k for k,v in book.items()}
for m in range(M):
    s=input()
    if s.isdigit():
        print(book[int(s)])
    else:
        print(inv_book[s])