# -*- coding: utf-8 -*-
"""
Created on Thu Apr 18 11:07:43 2019

@author: Young Deok
"""
deq = []
n=int(input())

for i in range(n):
    s=input()
    if s[0]=='s':
        print(len(deq))        
    elif s[0]=='e':
        if len(deq)==0:
            print(1)
        else:
            print(0)
    elif s[0]=='f':
        if(len(deq)==0):
            print(-1)
            continue
        print(deq[0])
    elif s[0]=='b':
        if(len(deq)==0):
            print(-1)
            continue
        print(deq[-1])
    elif s[1]=='o':
        if(len(deq)==0):
            print(-1)
            continue
        if s[4]=='f':
            print(deq[0])
            deq=deq[1:]
        else:
            print(deq[-1])
            deq=deq[:-1]
    elif s[5]=='f':
        deq.insert(0,int(s.split()[-1]))
    else:
        deq.append(int(s.split()[-1]))