# -*- coding: utf-8 -*-
"""
Created on Thu Mar 26 13:38:21 2020

@author: Young Deok
"""
s=''
n=int(input())
for i in range(1,n+1):
    for j in range(i):
        s+='*'
    s+='\n'
for i in range(n-1,0,-1):
    for j in range(i):
        s+='*'
    s+='\n'
print(s[:-1])