# -*- coding: utf-8 -*-
"""
Created on Tue Mar 19 17:25:05 2019

@author: Young Deok
"""

def include(a,b,r,x,y):
    d=pow(pow(a-x,2)+pow(b-y,2),0.5)
    if d>r:
        return False
    else:
        return True
    
T=int(input())
for t in range(T):
    s=input().split()
    Sx=int(s[0])
    Sy=int(s[1])
    Ex=int(s[2])
    Ey=int(s[3])
    N=int(input())
    rs=0
    for n in range(N):
        s=input().split()
        x=int(s[0])
        y=int(s[1])
        r=int(s[2])
        if include(Sx,Sy,r,x,y):
            if not include(Ex,Ey,r,x,y):
                rs+=1
        elif include(Ex,Ey,r,x,y):
            rs+=1
    print(rs)
            
