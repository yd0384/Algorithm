# -*- coding: utf-8 -*-
"""
Created on Thu Feb  7 14:20:55 2019

@author: Young Deok
"""
import re
def able(i,j,arr,m,n):
    ret=['u','d','r','l']
    if i==0:
        ret.remove('u')
    if j==0:
        ret.remove('l')
    if i==m-1:
        ret.remove('d')
    if j==n-1:
        ret.remove('r')
    return ret
def findpath(i,j,arr,m,n):
    a=arr[i][j]
    ret=0
    if i==m-1 and j==n-1:
        return 1
    fail=True
    ab = able(i,j,arr,m,n)
    if 'u' in ab:
        if a>arr[i-1][j]:
            ret+= findpath(i-1,j,arr,m,n)
            fail=False
    if 'd' in ab:
        if a>arr[i+1][j]:
            ret+= findpath(i+1,j,arr,m,n)
            fail=False
    if 'r' in ab:
        if a>arr[i][j+1]:
            ret+= findpath(i,j+1,arr,m,n)
            fail=False
    if 'l' in ab:
        if a>arr[i][j-1]:
            ret+= findpath(i,j-1,arr,m,n)
            fail=False
    if fail:
        return 0
    return ret
stdin=re.split('\s',input())
m=int(stdin[0])
n=int(stdin[1])

arr = [[0]*n for i in range(m)]
x=2
for i in range(0,m):
    for j in range(0,n):
        arr[i][j]=int(stdin[x])
        x+=1
i=0
j=0
print (findpath(i,j,arr,m,n))


