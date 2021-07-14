# -*- coding: utf-8 -*-
"""
Created on Thu Aug  1 16:00:03 2019

@author: Young Deok
"""
n=int(input())
a=1
b=2
if n==1:
    print(1)
elif n==2:
    print(2)
else:
    for i in range(3,n+1):
        r=(a+b)%15746
        a=b%15746
        b=r%15746
    print(r%15746)