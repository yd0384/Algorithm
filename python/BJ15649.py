# -*- coding: utf-8 -*-
"""
Created on Wed Jan 29 15:58:42 2020

@author: Young Deok
"""

inp=input().split(' ')
n=int(inp[0])
m=int(inp[1])
candi=[i for i in range(1,n+1)]

for i in range(1,m+1):
    for j in range(1,i+1):
        print(i,j)
