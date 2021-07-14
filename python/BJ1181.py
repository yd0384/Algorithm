# -*- coding: utf-8 -*-
"""
Created on Wed Apr 17 17:30:21 2019

@author: Young Deok
"""

n=int(input())

S=[]
for ns in range(n):
    S.append(input())

for i in range(1,51):    
    l=[]
    for s in S:
        if len(s)==i:
            if s not in l:
                l.append(s)
    l.sort()
    for s in l:
        print(s)