# -*- coding: utf-8 -*-
"""
Created on Tue Jan 21 17:38:44 2020

@author: Young Deok
"""

def summary(n):
    ret=n
    for c in str(n):
        ret+=int(c)
    return ret
l=list()
for i in range(1,1000001):
    l.append(summary(i))
n=int(input())
c=False
for i in range(n):
    if l[i]==n:
        print(i+1)
        c=True
        break
if not c:
    print(0)