# -*- coding: utf-8 -*-
"""
Created on Tue Feb  4 17:24:10 2020

@author: Young Deok
"""


T=int(input())
for t in range(T):
    N=int(input())
    before=input()
    after=input()
    bneed=0
    wneed=0
    for i in range(len(before)):
        if before[i]!=after[i]:
            if before[i]=='B':
                bneed+=1
            else:
                wneed+=1
    print(max(wneed,bneed))