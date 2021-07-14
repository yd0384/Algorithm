# -*- coding: utf-8 -*-
"""
Created on Mon Apr 29 15:57:41 2019

@author: Young Deok
"""
def boost(A,B,X):
    if visit[A-1]==True:
        return False
    if(visit[A-1]==False):
        visit[A-1]=True
    xSt=check[0][A-1]
    ySt=check[1][A-1]
    xDst=check[0][B-1]
    yDst=check[1][B-1]
    d=min(abs(xSt-xDst),abs(ySt-yDst))
    if d<=X:
        return True
    else:
        for n in range(0,len(check[0])):
            if n!=A-1 and n!=B-1:
                if visit[n]==False:
                    xDst=check[0][n]
                    yDst=check[1][n]
                    d=min(abs(xSt-xDst),abs(ySt-yDst))
                    if d<=X:
                        if boost(n+1,B,X):
                            return True
                        visit[n]=False
    return False

inp=input().split()
N=int(inp[0])
Q=int(inp[1])
check=list()
check.append(list())
check.append(list())
for n in range(N):
    inp=input().split()
    check[0].append(int(inp[0]))
    check[1].append(int(inp[1]))
for q in range(Q):
    visit=list()
    for n in range(N):
        visit.append(False)
    inp=input().split()
    A=int(inp[0])
    B=int(inp[1])
    X=int(inp[2])
    if (boost(A,B,X)):
        print("YES")
    else:
        print("NO")