import sys
N, M = [int(i) for i in input().split(' ')]
bookd=dict()
bookl=list()
for n in range(N):
    s=sys.stdin.readline().rstrip()
    bookd[s]=n+1
    bookl.append(s)
for m in range(M):
    s=sys.stdin.readline().rstrip()
    if s.isdigit():
        print(bookl[int(s)-1])
    else:
        print(bookd[s])