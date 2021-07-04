# -*- coding: utf-8 -*-
"""
Created on Thu Jun 24 17:58:49 2021

@author: yd0384
@Problem: https://www.acmicpc.net/problem/1013
given pattern: (100+1+ | 01)+
"""

import sys

T=int(sys.stdin.readline())
result=list()
for t in range(T):
    line = sys.stdin.readline().strip()
    if line[-1]=='0':
        r=False
        result.append(r)
        continue
    start=True
    i=0
    zero=True
    r=False
    while i<len(line):
        if start:
            if line[i]=='0':
                if line[i+1]=='0':
                    if i-2>0 and line[i-2:i+2]=='1100':
                        i=i+2
                        start=False
                        zero=True
                        continue
                    r=False
                    break
                i=i+2
                continue
            else:
                if line[i:i+3]!='100':
                    r=False
                    break
                i=i+3
                start=False
                continue
        elif zero:
            if line[i]=='1':
                zero=False

        else:
            if line[i]=='0':
                zero=True
                start=True
                continue
        i+=1
    if i==len(line):
        r=True
    result.append(r)
for r in (result):       
    if r:
        print('YES')
    else:
        print('NO')
