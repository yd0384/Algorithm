def recurr(N,r,c):
    if r==0 and c==0:
        return 0
    if r==0 and c==1:
        return 1
    if r==1 and c==0:
        return 2
    if r==1 and c==1:
        return 3
    i=2**(N-1)
    if r<i and c<i:
        return recurr(N-1,r,c)
    elif r<i and c>=i:
        return recurr(N-1,r,c-i) + 4**(N-1)
    elif r>=i and c<i:
        return recurr(N-1,r-i,c) + 2*4**(N-1)
    else:
        return recurr(N-1,r-i,c-i) + 3*4**(N-1)
import sys
sys.setrecursionlimit(10 ** 6)
N, r, c = [int(i) for i in input().split(' ')]
print(recurr(N,r,c))