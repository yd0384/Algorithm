# -*- coding: utf-8 -*-
"""
Created on Wed Mar 20 09:17:09 2019

@author: Young Deok
""" 
li=[[]]
for n in range(1,30):
    li.append(list())
    li[n].append(0)
    for m in range(n,30):
        if m==n:
            li[n].append(1)
        elif n==1:
            li[n].append(li[n][m-n]+1)
        else:
            li[n].append(li[n][m-n]+li[n-1][m-n+1])
T=int(input())
for t in range(T):
    s=input().split()
    n=int(s[0])
    m=int(s[1])
    print(li[n][m-n+1])
    