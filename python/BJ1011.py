# -*- coding: utf-8 -*-
"""
Created on Wed Apr 17 17:09:45 2019

@author: Young Deok
"""
t=int(input())
for never_use_this_dummy in range(t): 
    s=input().split(' ')
    x=int(s[0])
    y=int(s[1])
    d=y-x
    i=0
    n=0
    if d==1:
        print(1)
        continue
    while True:
       i+=1
       if d>i*2:
           d-=i*2
           n+=2
       elif d>i:
           n+=2
           break
       else:
           n+=1
           break
    print(n)