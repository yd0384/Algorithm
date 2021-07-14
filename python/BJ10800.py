# -*- coding: utf-8 -*-
"""
Created on Thu Apr  9 17:04:15 2020

@author: Young Deok
"""

N=int(input())
balls=list()
for n in range(N):
    inp=input().split(' ')
    balls.append((n,int(inp[0]),int(inp[1])))
balls.sort(key=lambda balls:balls[2])
colorball = [0 for i in range(N+1)]
sums = [0 for i in range(N)]
for ball in balls:
    colorball[ball[1]]+=ball[2]
        