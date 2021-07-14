# -*- coding: utf-8 -*-
"""
Created on Tue Mar 19 16:15:02 2019

@author: Young Deok
"""
s = input()
T = int(s)
i=0
for t in range(T):
    i=0
    s=input().split()
    x1=int(s[i])
    i+=1
    y1=int(s[i])
    i+=1
    r1=int(s[i])
    i+=1
    x2=int(s[i])
    i+=1
    y2=int(s[i])
    i+=1
    r2=int(s[i])
    i+=1
    d=pow(pow(x1-x2,2)+pow(y1-y2,2),0.5)
    if d==0:
        if r1-r2==0:
            rs=-1
        else:
            rs=0
    elif r1+r2==d or max(r1,r2)-min(r1,r2)==d:
        rs=1
    elif r1+r2>d:
        if max(r1,r2)-min(r1,r2)<d:
            rs=2
        else:
            rs=0
    else:
        rs=0
    print(rs)