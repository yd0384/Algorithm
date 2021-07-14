# -*- coding: utf-8 -*-
"""
Created on Mon Sep  2 16:00:47 2019

@author: Young Deok
"""
class Shark:
    def __init__(self):
        r=0
        c=0
        s=0
        d=0
        z=0
    def setData(r,c,s,d,z):
        self.r=r
        self.c=c
        self.s=s
        self.d=d
        self.z=z
    def move(R,C):        
inp=input().split()
R=int(inp[0])
C=int(inp[1])
board=list()
for r in range(R):
    board.append(list())
    for c in range(C):
        board[r].append(0)
sharks=list()
for m in range(M):
    inp=input().split()
    r=int(inp[0])
    c=int(inp[1])
    s=int(inp[2])
    d=int(inp[3])
    z=int(inp[4])
    shark=Shark()
    shark.setData(r,c,s,d,z)
    sharks.append(shark)
for c in range(C+1):
    for shark in Sharks:
        board[shark.r][shark.c]=1
    if c!=0:
        catch()
        for y in R:
            for x in C:
                board[y][x]=0
        for shark in Sharks:
            mov()
            if board[shark.r][shark.c]==1:
                
            board[shark.r][shark.c]=1
            