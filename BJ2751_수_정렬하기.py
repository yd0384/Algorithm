# -*- coding: utf-8 -*-
"""
Created on Sat Feb  6 17:06:29 2021

@author: young
"""
# can't run on spyder due to sys.stdin
import sys
MAX_NUM=2000001
N=int(sys.stdin.readline())
seq=list()
for n in range(N):
    seq.append(int(sys.stdin.readline()))
count=[0]*MAX_NUM
for i in seq:
    count[i+1000000]=1
for i in range(MAX_NUM):
    if count[i]==1:
        print(i-1000000)
