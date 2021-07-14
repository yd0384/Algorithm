# -*- coding: utf-8 -*-
"""
Created on Wed Aug 28 17:13:49 2019

@author: Young Deok
"""

i=input().split()
x=int(i[0])
y=int(i[1])
n=int(input())
xm=0
ym=0
l=list()
l.append(list())
l.append(list())
for j in range(n):
    i=input().split()
    l[int(i[0])].append(int(i[1]))
l[0].sort()
l[1].sort()
b=0
for i in range(0,len(l[0])):
    if ym<l[0][i]-b:
        ym=l[0][i]-b
    b=l[0][i]
if ym==0:
    ym=y
else:
    if ym<y-b:
        ym=y-b
b=0
for i in range(0,len(l[1])):
    if xm<l[1][i]-b:
        xm=l[1][i]-b
    b=l[1][i]
if xm==0:
    xm=x
else:
    if xm<x-b:
        xm=x-b
print(xm*ym)
    