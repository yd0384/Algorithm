# -*- coding: utf-8 -*-
"""
Created on Thu Mar 28 15:59:25 2019

@author: Young Deok
"""
T=int(input())
for t in range(T):
    N=int(input())
    points=[]
    for n in range(N):
        points.append([0,0,0,0])
        s=input().split()
        points[n][0]=int(s[0])
        points[n][1]=int(s[1])
        points[n][2]=int(s[2])
    x=0
    for n in range(N):
        if points[n][3]==0:
                x+=1
                points[n][3]=x         
        for a in range(n+1,N):
            d=pow(pow(points[a][0]-points[n][0],2)+pow(points[a][1]-points[n][1],2),0.5)
            if d<=points[a][2]+points[n][2]:
                points[a][3]=points[n][3]
    print(x)
