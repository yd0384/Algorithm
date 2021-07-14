# -*- coding: utf-8 -*-
"""
Created on Thu Mar 28 15:03:26 2019

@author: Young Deok
"""

T=int(input())

for t in range(T):
    Y=0
    K=0
    for i in range(9):
        s=input().split()
        y=s[0]
        k=s[1]
        if y>k:
            Y+=1
        elif y<k:
            K+=1
    if Y>K:
        print("Yonsei")
    elif Y==K:
        print("Draw")
    else:
        print("Korea")