# -*- coding: utf-8 -*-
"""
Created on Sat Feb  6 15:36:21 2021

@author: young
"""

def lis(seq):
    if len(seq)==1:
        return 1
    if seq[0]<seq[1]:
        return lis(seq[1:])+1
    else:
        return lis(seq[1:])
    
C=int(input())
for c in range(C):
    inp=input().split(' ')
    N=int(inp[0])
    K=int(inp[1])
    inp=input().split(' ')
    seq=list()
    for n in inp:
       seq.append(int(n))
    l1=list()
    l1.append(seq[0])
    index=0
    for i in range(1,N):
        if l1[index]<seq[i]:
            index=index+1
            l1.append(seq[i])
        else:
            for j in range(len(l1)):
                if seq[i]<l1[j]:
                    l1[j]=seq[i]
                    break 
    L=len(l1)
    print(lis(seq))
