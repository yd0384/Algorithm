# -*- coding: utf-8 -*-
"""
Created on Tue Jan 21 17:10:24 2020

@author: Young Deok
"""

n=int(input())
A=[int(x) for x in input().split(' ')]
L=list()
d=0
for i in range(0,n):
    if len(L)==0:
        L.append(A[i])
        d=d+1
    elif A[i]>L[d-1]:
        L.append(A[i])
        d=d+1
    else:
        for j in range(0,d):
            if A[i] <= L[j]:
                L[j]=A[i]
                break
print(len(L))