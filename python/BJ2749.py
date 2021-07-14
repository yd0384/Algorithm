# -*- coding: utf-8 -*-
"""
Created on Thu Feb  7 15:55:01 2019

@author: Young Deok
"""
n=int(input())
F=[]
F.append(0)
F.append(1)
for i in range(1500000):
    F.append((F[i]+F[i+1])%1000000)
print(F[n%1500000])