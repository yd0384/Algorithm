# -*- coding: utf-8 -*-
"""
Created on Thu Feb  7 15:40:33 2019

@author: Young Deok
"""
string=input()
a=string.split('\n')[0]
b=string.split('\n')[1]
arr1=[0*i for i in range(26)]
arr2=[0*i for i in range(26)]
for i in a:
    arr1[ord(i)-65]+=1
for j in b:
    arr2[ord(j)-65]+=1
l=0
for i in range(0,26):
   l+=min(arr1[i],arr2[i])
print(l)