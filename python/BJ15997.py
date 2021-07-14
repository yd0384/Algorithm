# -*- coding: utf-8 -*-
"""
Created on Thu Aug  1 15:53:08 2019

@author: Young Deok
"""
def sortNat(l,nations):
    n1=l[0]
    n2=l[1]
    i1=0
    i2=0
    for i in range(len(nations)):
        if nations[i]==n1:
            i1=i
        elif nations[i]==n2:
            i2=i
    if i1>i2:
        l[0]=n2
        l[1]=n1
    return l
nations = input().split(' ')
nations.sort()
ABWDL=list()
for i in range(6):
    ABWDL.append(input().split(' '))
    ABWDL[i]=sortNat(ABWDL[i],nations)
    
ABWDL.sort()
score={}
for n in nations:
    score[n]=0.0
for l in ABWDL:
    score[l[0]]+=3.0*float(l[2])
    score[l[1]]+=3.0*float(l[4])
    score[l[0]]+=float(l[3])
    score[l[1]]+=float(l[3])