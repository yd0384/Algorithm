# -*- coding: utf-8 -*-
"""
Created on Tue Apr  9 13:54:20 2019

@author: Young Deok
"""
n=int(input())
x=n*2-1
sArr = [' '*(x//2) + '*' + ' ' *(x//2)]+[' '*x]*(n-1)
for i in range(n):
    if i%3==1:
        sArr[i]=sArr[i-1].replace(' * ','* *')
    elif i%3==2:
        sArr[i]=sArr[i-1].replace(' * * ','*****')
    elif i!=0:
        l = [' ']*x
        for s in range(x):
             if sArr[i-1][s]=='*' and sArr[i-1][s+1]=='*' and sArr[i-1][s+2]=='*' and sArr[i-1][s+3]=='*' and sArr[i-1][s+4]=='*':
                 if sArr[i-1][s-2]!='*':
                     l[s-1]='*'
                 if sArr[i-1][s+6]!='*':
                     l[s+5]='*'
        sArr[i]=''.join(l)
for s in sArr:
    print(s)