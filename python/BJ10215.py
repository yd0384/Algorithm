# -*- coding: utf-8 -*-
"""
Created on Thu Mar 28 15:10:42 2019

@author: Young Deok
"""

T=int(input())
for t in range(T):
    s=input().split()
    n=int(s[0])
    plate=list()    
    for i in range(4):
        S=input()
        plate.append(list())
        plate[i].append(S[0])
        plate[i].append(S[1])
        plate[i].append(S[2])
        plate[i].append(S[3])
    arr=[['E','E','E','E'],['E','E','E','E'],['E','E','E','E'],['E','E','E','E']]
    for N in range(n):
        if s[N+1]='W':
            