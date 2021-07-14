# -*- coding: utf-8 -*-
"""
Created on Tue Apr  9 13:42:39 2019

@author: Young Deok
"""

n=int(input())
iF=n//5
iT=0
while True:
    if iF==-1 and iT==0:
        print(-1)
        break
    if n==iF*5+iT*3:
        print(iF+iT)
        break
    elif n<iF*5+iT*3:
        iT=0
        iF-=1
    elif n>iF*5+iT*3:
        iT+=1
