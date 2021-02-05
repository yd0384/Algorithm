# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

AL=list()
AL.append(0)
AL.append(0)
AL.append(1)
AL.append(1)
for i in range(4,1000001):
    r3=9999999
    r2=9999999
    if i%3==0:
        r3=AL[int(i/3)]+1
    if i%2==0:
        r2=AL[int(i/2)]+1
    AL.append(min(r2,r3,AL[i-1]+1))
n=int(input())
print(AL[n])