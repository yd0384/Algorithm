# -*- coding: utf-8 -*-
"""
Created on Thu Aug  1 15:37:24 2019

@author: Young Deok
"""
sames=list()
diffs=list()
S=input().split("&&")
for s in S:
    sa=s.split("==")
    if len(sa)==2:
        sames.append(list())
        sames[-1].append(sa[0])
        sames[-1].append(sa[-1])
        